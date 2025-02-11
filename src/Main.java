import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static int N, M;
	private static int adj[][];
	private static boolean visited[];
	private static int cnt;
	private static void dfs(int node) {
		visited[node] = true;
		cnt++;
		for(int i=1; i<=N;i++) {
			if(!visited[i] && adj[node][i] == 1) {
				dfs(i);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1;
			adj[b][a] = 1;
		}
		dfs(1);
		System.out.println(cnt - 1); // 1번 컴퓨터는 빼야 하므로
	}
}