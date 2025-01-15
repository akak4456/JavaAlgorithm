import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int maxVal = Integer.MIN_VALUE;
		int sumVal = 0;
		for(int i=0;i<N;i++) {
			sumVal += arr[i];
			if(arr[i] > maxVal) {
				maxVal = arr[i];
			}
		}
		System.out.println((double) sumVal / maxVal * 100 / N);
	}
}