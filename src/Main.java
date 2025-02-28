import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static int N;
	private static int dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2; i<=N; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for(int i=0;i<=N;i++) {
			for(int j=1;i + j*j <= N;j++) {
				dp[i + j*j] = Math.min(dp[i + j*j],dp[i] + 1);
			}
		}
		System.out.println(dp[N]);
	}
}