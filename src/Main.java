import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
	private static int N, M;
	private static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long start = 0;
		long end = 2000000000;

		while(start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			for(int i=0;i<N;i++) {
				if(arr[i] > mid) {
					sum += arr[i] - mid;
				}
			}
			if(sum >= M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(end);
	}
}