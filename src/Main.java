import java.io.*;
import java.util.*;
public class Main {
	private static int A, B;
	private static final int INF = 987654321;
	private static int ans = INF;
	private static void solve(int cur, int cnt) {
		if(cur == 0) {
			return;
		}
		if(cur == A) {
			ans = Math.min(ans, cnt + 1);
			return;
		}
		if(cur % 2 == 0) {
			solve(cur / 2, cnt + 1);
		}
		if(cur % 10 == 1) {
			solve(cur / 10, cnt + 1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		solve(B, 0);
		if(ans == INF) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
}