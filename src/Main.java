import java.io.*;
import java.util.*;

public class Main {

	private static int N, M;

	private static int[] arr;

	private static StringBuilder sb = new StringBuilder();

	private static void solve(int used, ArrayList<Integer> list) {
		if(list.size() == M) {
			for(int i=0;i<list.size();i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<N;i++) {
			if((used & (1 << i)) > 0) continue;
			list.add(arr[i]);
			solve(used | (1 << i), list);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
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
		solve(0,new ArrayList<>());
		System.out.println(sb);
	}

}