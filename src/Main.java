import java.io.*;
import java.util.*;
public class Main {
	private static int N;
	private static int[] arr;
	private static final int MOD = 1_000_000_007;
	private static long[] powArr;
	private static long ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		powArr = new long[300000 + 1];
		powArr[0] = 1;
		for(int i=1;i<=300000;i++) {
			powArr[i] = (powArr[i - 1] * 2) % MOD;
		}
		for(int i=0;i<N;i++) {
			ans += arr[i] * powArr[i];
			ans -= arr[i] * powArr[N - i - 1];
			ans %= MOD;
		}
		System.out.println(ans % MOD);
	}
}