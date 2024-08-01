import java.io.*;
import java.util.*;

public class Main {
	private static int N;

	private static int[] dp;

	private static int solve(int n) {
		if(n <= 1) {
			return 1;
		}
		if(dp[n] != -1) {
			return dp[n];
		}
		dp[n] = solve(n - 1) % 10007;
		dp[n] = (dp[n] + solve(n - 2)) % 10007;
		dp[n] = (dp[n] + solve(n - 2)) % 10007;
		return dp[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		Arrays.fill(dp, -1);
		System.out.println(solve(N));
	}
}