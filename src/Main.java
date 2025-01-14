import java.io.*;
import java.util.*;

public class Main {
	private static int N, M;
	private static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int minDiff = Integer.MAX_VALUE;
		int result = -1;
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				for(int k=j+1;k<N;k++){
					if(arr[i] + arr[j] + arr[k] <= M) {
						int diff = Math.abs(M - (arr[i] + arr[j] + arr[k]));
						if (diff < minDiff) {
							minDiff = diff;
							result = arr[i] + arr[j] + arr[k];
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}