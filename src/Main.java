import java.io.*;
import java.util.*;

public class Main {

	private static int N, M;

	private static StringBuilder sb;

	private static void solve(int cnt, int start, ArrayList<Integer> list) {
		if(cnt == M) {
			for(int i=0;i<list.size();i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<=N;i++) {
			list.add(i);
			solve(cnt + 1, i, list);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();

		solve(0,1, new ArrayList<>());

		System.out.println(sb);
	}

}