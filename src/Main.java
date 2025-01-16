import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int[] arr;
	public static void main(String[] args) throws Exception {
		// 입력 최적화를 위해서 Scanner 대신에 BufferedReader, StringTokenizer 를
		// 혼합하는 방식으로 사용함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			sb.append(arr[i]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}