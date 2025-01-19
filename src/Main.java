import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int x[];
	private static int y[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		x = new int[N];
		y = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			int curRank = 1;
			for(int j=0;j<N;j++) {
				if(i == j) continue;
				if(x[j] > x[i] && y[j] > y[i]) {
					curRank++;
				}
			}
			sb.append(curRank);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}