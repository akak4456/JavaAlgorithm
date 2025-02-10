import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	private static int N;
	private static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[1000000 + 1];
		dp[1] = 0;
		for(int i=2;i<=N;i++) {
			dp[i] = dp[i-1] + 1; // 1을 빼는 경우의 수
			if(i >= 2 && i%2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2] + 1); // 2로 나누는 경우의 수
			}
			if(i >= 3 && i%3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3] + 1); // 3로 나누는 경우의 수
			}
		}
		System.out.println(dp[N]);
	}
}