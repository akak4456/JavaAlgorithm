import java.io.*;
import java.util.*;

public class Main {
	private static int K, N;
	private static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[K];
		for(int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		long start = 0;
		long end = Integer.MAX_VALUE;
		long result = 0;
		while(start <= end) {
			long mid = (start + end) / 2;
			int cnt = 0;
			for(int i=0;i<K;i++) {
				cnt += arr[i] / mid;
			}
			if(cnt >= N) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(result);
	}
}