import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
	private static int N;
	private static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(-pq.poll());
				}
			} else {
				pq.add(-x);
			}
		}
	}
}