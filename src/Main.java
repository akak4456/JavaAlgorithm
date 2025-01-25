import java.io.*;
import java.util.*;

public class Main {
	private static boolean isPrime[];
	private static int M, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		isPrime = new boolean[1000000+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for(int i=2;i<=1000000;i++) {
			if(isPrime[i]) {
				for(int j=i*2;j<=1000000;j+=i) {
					isPrime[j] = false;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=M;i<=N;i++) {
			if(isPrime[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}
}