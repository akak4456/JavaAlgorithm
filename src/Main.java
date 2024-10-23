import java.io.*;
import java.util.*;
class Node {
	int data;
	int idx;
}
public class Main {
	private static int N;
	private static Node[] nodes;
	private static int[] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		nodes = new Node[N];
		ans = new int[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node();
			nodes[i].data = Integer.parseInt(st.nextToken());
			nodes[i].idx = i;
		}
		Arrays.sort(nodes, Comparator.comparingInt(o -> o.data));
		int newCoordinate = 0;
		int curData = nodes[0].data;
		for (int i = 0; i < N; i++) {
			if (nodes[i].data != curData) {
				newCoordinate++;
				curData = nodes[i].data;
			}
			ans[nodes[i].idx] = newCoordinate;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb);
	}
}