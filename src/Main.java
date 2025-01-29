import java.io.*;
import java.util.*;

class IntPair implements Comparable<IntPair> {
	private int first;
	private int second;

	public IntPair(int first, int second) {
		this.first = first;
		this.second = second;
	}

	public int getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
	}

	@Override
	public int compareTo(IntPair o) {
		if(Integer.compare(this.first, o.first) == 0) {
			return Integer.compare(this.second, o.second);
		}
		return Integer.compare(o.first, this.first);
	}

}

public class Main {
	private static int N;
	private static int[] arr;
	private static PriorityQueue<IntPair> pq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		double sum = 0.0;
		for(int i=0; i<N;i++) {
			sum += arr[i];
		}
		double avg = sum / N;
		int avgInt = (int)Math.round(avg);
		System.out.println(avgInt);
		Arrays.sort(arr);
		System.out.println(arr[N / 2]);
		int plus[] = new int[4000 + 1];
		int minus[] = new int[4000 + 1];
		for(int i=0;i<N;i++) {
			if(arr[i] >= 0) {
				plus[arr[i]]++;
			} else {
				minus[arr[i] * -1]++;
			}
		}
		pq = new PriorityQueue<>();
		for(int i=0;i<plus.length;i++) {
			if(plus[i] > 0) {
				pq.add(new IntPair(plus[i], i));
			}
		}
		for(int i=0;i<minus.length;i++) {
			if(minus[i] > 0) {
				pq.add(new IntPair(minus[i], -i));
			}
		}
		IntPair p1 = pq.poll();
		IntPair p2 = null;
		if(!pq.isEmpty()) {
			p2 = pq.poll();
		}
		IntPair target = p1;
		if(p2 != null && p1.getFirst() == p2.getFirst()) {
			target = p2;
		}
		System.out.println(target.getSecond());
		System.out.println(arr[N - 1] - arr[0]);
	}
}