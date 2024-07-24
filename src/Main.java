import java.io.*;
import java.util.*;

public class Main {
	private static int N, M;
	private static int[] arr;
	private static int[] sum;
	private static int[] group;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		sum = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i - 1]  + arr[i];
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			int a,b;
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			sb.append(sum[b] - sum[a - 1]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}