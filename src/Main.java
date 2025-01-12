import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] arr;
	private static boolean isPrime(int n) {
		if(n <= 1) return false;
		if(n == 2) return true;
		for(int i=2;i<n;i++) {
			if(n%i==0) return false;
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		for(int i=0;i<N;i++) {
			if(isPrime(arr[i])) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}