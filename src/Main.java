import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
	private static int N, M, V;
	private static ArrayList<ArrayList<Integer>> adj;
	private static boolean[] visited;
	private static StringBuilder dfsResult = new StringBuilder();
	private static StringBuilder bfsResult = new StringBuilder();
	private static void dfs(int node) {
		if(visited[node]) return;
		visited[node] = true;
		dfsResult.append(node).append(" ");
		for(int i=0; i<adj.get(node).size(); i++) {
			if(!visited[adj.get(node).get(i)]) {
				dfs(adj.get(node).get(i));
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		adj = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		for(int i=0;i<=N;i++) {
			Collections.sort(adj.get(i));
		}
		visited = new boolean[N + 1];
		dfs(V);
		visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(V);
		while(!q.isEmpty()) {
			int node = q.poll();
			if(visited[node]) continue;
			visited[node] = true;
			bfsResult.append(node).append(" ");
			for(int i=0;i<adj.get(node).size();i++) {
				if(!visited[adj.get(node).get(i)]) {
					q.add(adj.get(node).get(i));
				}
			}
		}
		System.out.println(dfsResult);
		System.out.println(bfsResult);
	}
}