import java.io.*;
import java.util.*;

public class Main {
	private static int N, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int comb = 1;
		for(int i=N; i>=N-K+1;i--) {
			comb *= i;
		}
		for(int i=1;i<=K;i++) {
			comb /= i;
		}
		System.out.println(comb);
	}
}