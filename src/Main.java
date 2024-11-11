import java.io.*;
import java.util.*;
public class Main {
	private static int N;
	private static ArrayList<ArrayList<Integer>> graph;
	private static int[] parent;
	private static boolean[] visited;
	private static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		parent = new int[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(parent, -1);
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		q = new LinkedList<>();
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		q.add(1);
		while(!q.isEmpty()) {
			int node = q.poll();
			// System.out.println(node);
			if(visited[node]) continue;
			visited[node] = true;
			for(int i=0;i<graph.get(node).size();i++) {
				int adj = graph.get(node).get(i);
				if(parent[adj] == -1) {
					parent[adj] = node;
				}
				q.add(adj);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=2;i<=N;i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
	}
}