import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int N;
	private static final int MOD = 10007;
	private static long[][] cache;
	private static final int TOTAL_CARD = 52;
	private static long nCr(int n, int r) {
		if(r > n / 2) {
			return nCr(n, n-r);
		}
		if(r == 1) {
			return n;
		}
		if(r == 0) {
			return 1;
		}
		if(cache[n][r] != -1) return cache[n][r];
		long ret = (nCr(n-1,r-1) + nCr(n-1,r)) % MOD;
		cache[n][r] = ret;
		return ret;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cache = new long[100][100];
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				cache[i][j] = -1;
			}
		}
		if(N < 4) {
			System.out.println(0);
		} else {
			long ans = 0;
			boolean addStep = true;
			int step = 4;
			while(step <= N) {
				if(addStep) {
					ans = (ans + nCr(TOTAL_CARD / 4, step / 4) * nCr(TOTAL_CARD - step, N - step)) % MOD;
				}else {
					ans = (ans - nCr(TOTAL_CARD / 4, step/4) * nCr(TOTAL_CARD - step, N - step) + MOD) % MOD;
				}
				addStep = !addStep;
				step += 4;
			}
			while(ans < 0) {
				ans += MOD;
			}
			System.out.println(ans);
		}
	}
}