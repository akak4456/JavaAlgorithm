import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static int N, K;
	private static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		for(int i=N-1;i>=0;i--) {
			while(K >= arr[i]) {
				K -= arr[i];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}