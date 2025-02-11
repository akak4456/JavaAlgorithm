import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static int N;
	private static int[] arr;
	private static int[][] dp;
	private static int solve(int curPos, int curStep) {
		if(dp[curPos][curStep] != -1) return dp[curPos][curStep];
		if (curStep == 2 && curPos == N - 1) {
			return Integer.MIN_VALUE;
		}
		if(curPos == N) return 0;
		int ret = 0;
		if(curStep < 2 && curPos + 1 <= N) {
			ret = Math.max(ret, solve(curPos + 1, curStep + 1) + arr[curPos + 1]);
		}
		if(curPos + 2 <= N) {
			ret = Math.max(ret, solve(curPos + 2, 1) + arr[curPos + 2]);
		}
		dp[curPos][curStep] = ret;
		return ret;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new int[N + 1][3];
		for(int i=0;i<=N;i++) {
			Arrays.fill(dp[i], -1);
		}
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(solve(0,0));
	}
}