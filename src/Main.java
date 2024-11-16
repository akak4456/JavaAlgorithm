import java.io.*;
import java.util.*;
public class Main {
	private static int N;
	private static int[][] dp;
	private static int[][] RGB;
	private static int solve(int idx, int prevColorIdx) {
		int ret = 987654321;
		if(idx == N) return 0;
		if(dp[idx][prevColorIdx] != -1) {
			return dp[idx][prevColorIdx];
		}
		for(int i=1;i<=3;i++) {
			if(prevColorIdx == i) continue;
			ret = Math.min(ret, RGB[idx][i] + solve(idx + 1, i));
		}
		dp[idx][prevColorIdx] = ret;
		return ret;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N][4];
		RGB = new int[N][4];
		for(int i=0;i<N;i++) {
			for(int j=0;j<4;j++) {
				dp[i][j] = -1;
			}
		}
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=3;j++) {
				RGB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(solve(0, 0));
	}
}