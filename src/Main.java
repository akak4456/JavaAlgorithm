import java.io.*;
import java.util.*;
class Node implements Comparable<Node> {
	int start;
	int end;


	@Override
	public int compareTo(Node o) {
		return Integer.compare(start, o.start);
	}

	@Override
	public String toString() {
		return "Node{" +
				"start=" + start +
				", end=" + end +
				'}';
	}
}

public class Main {
	private static int N;
	private static Node[] nodes;
	private static int L;
	private static ArrayList<Integer> start;
	private static ArrayList<Integer> end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes[i] = new Node();
			nodes[i].start = Math.min(a, b);
			nodes[i].end = Math.max(a, b);
		}
		L = Integer.parseInt(br.readLine());
		start = new ArrayList<>();
		end = new ArrayList<>();
		for(int i=0;i<N;i++) {
			if(nodes[i].end - nodes[i].start <= L) {
				start.add(nodes[i].start);
				end.add(nodes[i].end);
			}
		}
		Collections.sort(start);
		Collections.sort(end);
		int ans = 0;
		if(!start.isEmpty()) {
			int startCnt = 0;
			int startTarget = start.get(0);
			for (int i = 0; i < start.size(); i++) {
				if (startTarget != start.get(i)) {
					startCnt = i;
					startTarget = start.get(i);
				}
				int endIdx = upper(end, start.get(i) + L);
				int endCnt = end.size() - endIdx;
				ans = Math.max(ans, end.size() - (startCnt + endCnt));
			}
		}
		System.out.println(ans);
	}

	private static int upper(ArrayList<Integer> list, int key) {
		int start = 0;
		int end = list.size() - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(list.get(mid) <= key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start;
	}
}