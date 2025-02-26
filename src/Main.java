import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static int N;
	private static int dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[1000 + 1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=1000;i++) {
			dp[i] = (dp[i-1] + dp[i - 2]) % 10007;
		}
		System.out.println(dp[N]);
	}
}