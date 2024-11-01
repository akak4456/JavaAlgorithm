import java.io.*;
import java.util.*;
class Node {
	int pos;
	int cnt;

	Node(int pos, int cnt) {
		this.pos = pos;
		this.cnt = cnt;
	}
}
public class Main {
	private static int N, M;
	private static StringBuilder sb = new StringBuilder();
	private static void solve(int cur, int cnt, String cul) {
		if(cnt == M) {
			sb.append(cul.trim());
			sb.append('\n');
			return;
		}
		for(int i=cur;i<=N;i++) {
			solve(i, cnt+1, cul + " " + i);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		solve(1,0,"");
		System.out.println(sb);
	}
}