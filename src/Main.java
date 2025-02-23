import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static int T;
	private static int N;
	private static long dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		dp = new long[100 + 1];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		for(int i=4;i<=100;i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		for(int testCase = 0; testCase < T; testCase++) {
			N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
	}
}