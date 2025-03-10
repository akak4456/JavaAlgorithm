import java.io.*;
import java.util.*;
class P implements Comparable<P> {
	int start;
	int end;

	public P(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(P o) {
		if(this.end == o.end) {
			return Integer.compare(this.start, o.start);
		}
		return Integer.compare(this.end, o.end);
	}
}
public class Main {
	private static int N;
	private static P[] pair;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pair = new P[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pair[i] = new P(a, b);
		}
		Arrays.sort(pair);
		int endTime = 0;
		int cnt = 0;
		for(int i=0;i<N;i++) {
			if(pair[i].start >= endTime) {
				endTime = pair[i].end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}