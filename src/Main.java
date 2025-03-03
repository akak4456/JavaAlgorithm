import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
	private static int N, M;
	private static int[][] adj;
	private static boolean[] visited;
	private static void dfs(int node) {
		if(visited[node]) return;
		visited[node] = true;
		for(int i=1;i<=N;i++) {
			if(adj[node][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1;
			adj[b][a] = 1;
		}
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
		System.out.println(cnt);
	}
}