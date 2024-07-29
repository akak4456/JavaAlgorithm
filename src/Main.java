import java.io.*;
import java.util.*;

public class Main {
	private static int N, M;
	private static int mask;
	private static int allMask;
	private static boolean[][] adj;
	private static boolean[] visited;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];
		for(int i=0;i < M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = true;
			adj[b][a] = true;
		}
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				ans++;
				dfs(i);
			}
		}
		System.out.println(ans);
	}

	private static void dfs(int node) {
		if(visited[node]) return;
		visited[node] = true;
		for(int other=1;other<=N;other++) {
			if(node == other || visited[other]) continue;
			if(adj[node][other]) {
				dfs(other);
			}
		}
	}
}