import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static int T;
	private static int N;
	private static int[] dp0;
	private static int[] dp1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		dp0 = new int[40 + 1];
		dp1 = new int[40 + 1];
		dp0[0] = 1;
		dp1[0] = 0;
		dp0[1] = 0;
		dp1[1] = 1;
		for(int i=2;i<=40;i++) {
			dp0[i] = dp0[i-1] + dp0[i-2];
			dp1[i] = dp1[i-1] + dp1[i-2];
		}
		StringBuilder sb = new StringBuilder();
		for(int testCase = 0; testCase < T; testCase++) {
			N = Integer.parseInt(br.readLine());
			sb.append(dp0[N]).append(" ").append(dp1[N]).append("\n");
		}
		System.out.println(sb);
	}
}