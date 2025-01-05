import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	private static int N;
	private static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			if(arr[i] < minVal) {
				minVal = arr[i];
			}
			if(arr[i] > maxVal) {
				maxVal = arr[i];
			}
		}
		System.out.println(minVal + " " + maxVal);
	}
}