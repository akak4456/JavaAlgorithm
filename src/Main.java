import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static int T;
	private static int dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		dp = new int[10 + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4;i<=10;i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		for(int testCase = 0; testCase < T; testCase++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}
}