import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int A[];
	private static int M;
	private static boolean binarySearch(int target) {
		int start = 0;
		int end = N - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(target == A[mid]){
				return true;
			}
			else if(target < A[mid]) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(binarySearch(a)) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}
}