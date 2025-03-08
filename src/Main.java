import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class P {
	int position;
	int time;
	public P(int position, int time) {
		this.position = position;
		this.time = time;
	}
}
public class Main {
	private static int N, K;
	private static Queue<P> queue;
	private static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100000 + 1];
		queue = new LinkedList<>();
		queue.add(new P(N, 0));
		int minTime = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			P p = queue.poll();
			if(visited[p.position]) continue;
			visited[p.position] = true;
			if(p.position == K && p.time < minTime) {
				minTime = p.time;
			}
			if(p.position - 1 >= 0) {
				queue.add(new P(p.position - 1, p.time + 1));
			}
			if(p.position + 1 <= 100000) {
				queue.add(new P(p.position + 1, p.time + 1));
			}
			if(p.position*2 <= 100000) {
				queue.add(new P(p.position * 2, p.time + 1));
			}
		}
		System.out.println(minTime);
	}
}