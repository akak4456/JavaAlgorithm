import java.io.*;
import java.util.*;
class P implements Comparable<P> {
	int value;
	int absValue;

	public P(int value) {
		this.value = value;
		this.absValue = Math.abs(value);
	}
	@Override
	public int compareTo(P o) {
		if(this.absValue == o.absValue) {
			return Integer.compare(this.value, o.value);
		}
		return Integer.compare(this.absValue, o.absValue);
	}
}
public class Main {
	private static int N;
	private static PriorityQueue<P> pq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pq.poll().value);
				}
			} else {
				pq.add(new P(x));
			}
		}
	}
}