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
	private static int[] ladder;
	private static int[] snake;
	private static Queue<Node> q = new LinkedList<>();
	private static int[] curCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ladder = new int[101];
		snake = new int[101];
		curCnt = new int[101];
		Arrays.fill(ladder, -1);
		Arrays.fill(snake, -1);
		Arrays.fill(curCnt, Integer.MAX_VALUE);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			ladder[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			snake[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		q.add(new Node(1, 0));
		int ans = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.pos == 100) {
				ans = Math.min(ans, cur.cnt);
				continue;
			}
			// System.out.println(cur.pos + ":" + cur.cnt);
			if(cur.cnt >= curCnt[cur.pos]) {
				continue;
			}
			curCnt[cur.pos] = cur.cnt;
			if(ladder[cur.pos] != -1) {
				q.add(new Node(ladder[cur.pos], cur.cnt));
				continue;
			}
			if(snake[cur.pos] != -1) {
				q.add(new Node(snake[cur.pos], cur.cnt));
				continue;
			}
			for(int i=1;i<=6;i++) {
				if(cur.pos + i > 100) break;
				q.add(new Node(cur.pos + i, cur.cnt + 1));
			}
		}
		System.out.println(ans);
	}
}