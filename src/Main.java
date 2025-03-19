import java.io.*;
import java.util.*;

public class Main {

	private static int N, M;

	private static StringBuilder sb;

	private static void solve(int used, int cnt, int start) {
		if(cnt == M) {
			for(int i=1;i<=N;i++) {
				if((used & (1 << i)) > 0) {
					sb.append(i).append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<=N;i++) {
			if((used & (1 << i)) > 0) continue;
			solve(used | (1 << i), cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();

		solve(0,0, 1);

		System.out.println(sb);
	}

}