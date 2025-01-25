import java.io.*;
import java.util.*;

public class Main {
	private static int n;
	private static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int cutCount = (int)Math.round((double)n * 0.15);
		int sum = 0;
		for(int i=cutCount;i<n-cutCount;i++) {
			sum += arr[i];
		}
		int ans = (int)Math.round((double) sum / (n - cutCount * 2));
		System.out.println(ans);
	}
}