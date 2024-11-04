import java.io.*;
import java.util.*;
class Node {
	int pos;
	int cnt;

	Node(int pos, int cnt) {
		this.pos = pos;
		this.cnt = cnt;
	}
}
public class Main {
	private static int N, M;
	private static int arr[];
	private static StringBuilder sb = new StringBuilder();
	private static void solve(int used, int cnt, String cul) {
		if(cnt == M) {
			sb.append(cul.trim());
			sb.append('\n');
			return;
		}
		for(int i=0;i<N;i++) {
			if((used & (1 << i)) == 0) {
				solve(used | (1 << i), cnt + 1, cul + " " + arr[i]);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		solve(0,0,"");
		System.out.println(sb);
	}
}