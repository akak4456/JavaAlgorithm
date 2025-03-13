import java.io.*;
import java.util.*;
class P{
	int pos;
	int time;
	public P(int pos, int time){
		this.pos = pos;
		this.time = time;
	}
}
public class Main {
	private static int N, M;
	private static int[] ladder;
	private static int[] snake;
	private static Queue<P> queue;
	private static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ladder = new int[100 + 1];
		snake = new int[100 + 1];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladder[a] = b;
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			snake[a] = b;
		}
		queue = new LinkedList<>();
		queue.add(new P(1, 0));
		visited = new boolean[100 + 1];
		int minTime = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			P p = queue.poll();
			if(visited[p.pos]) continue;
			visited[p.pos] = true;
			if(p.pos == 100) {
				minTime = Math.min(minTime, p.time);
				continue;
			}
			for(int i=1;i<=6;i++) {
				int newPos = p.pos + i;
				if(newPos > 100) break;
				if(ladder[newPos] != 0) {
					newPos = ladder[newPos];
				}
				if(snake[newPos] != 0) {
					newPos = snake[newPos];
				}
				queue.add(new P(newPos, p.time+1));
			}
		}
		System.out.println(minTime);
	}
}