import java.io.*;
import java.util.*;

public class Main {
	private static int N, K;
	private static Deque<Integer> deque;
	private static ArrayList<Integer> ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		deque = new ArrayDeque<>();
		ans = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			deque.addLast(i);
		}
		while(!deque.isEmpty()) {
			for(int i=1;i<=K-1;i++) {
				deque.addLast(deque.removeFirst());
			}
			ans.add(deque.removeFirst());
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i=0;i<ans.size()-1;i++) {
			sb.append(ans.get(i)).append(", ");
		}
		sb.append(ans.get(ans.size()-1)).append(">");
		System.out.println(sb);
	}
}