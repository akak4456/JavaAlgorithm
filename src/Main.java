import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static int N, M;
	private static int[] arr;
	private static int[] sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		sum = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = arr[i] + sum[i - 1];
		}
		StringBuilder sb = new StringBuilder();
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(sum[j] - sum[i-1]).append("\n");
		}
		System.out.println(sb);
	}
}