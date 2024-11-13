import java.io.*;
import java.util.*;
public class Main {
	private static int N, M;
	private static int[] cnt;
	private static StringBuilder sb;
	private static void solve(int startIdx, int remainCnt, String cur) {
		if(remainCnt == 0) {
			sb.append(cur.trim());
			sb.append('\n');
			return;
		}
		for(int i=startIdx;i<=10000;i++) {
			if(cnt[i] > 0) {
				solve(i, remainCnt - 1, cur + " " + i);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		cnt = new int[10000 + 1];
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			cnt[tmp]++;
		}
		sb = new StringBuilder();
		solve(0, M, "");
		System.out.println(sb);
	}
}