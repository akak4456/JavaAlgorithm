import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static int N;
	private static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		int cum = 0;
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			cum += arr[i];
			result += cum;
		}
		System.out.println(result);
	}
}