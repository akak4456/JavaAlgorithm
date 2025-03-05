import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class P implements Comparable<P> {
	int idx;
	int value;

	@Override
	public int compareTo(P o) {
		return this.value - o.value;
	}
}
public class Main {
	private static int N;
	private static ArrayList<P> arr;
	private static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			P p = new P();
			p.idx = i;
			p.value = Integer.parseInt(st.nextToken());
			arr.add(p);
		}
		Collections.sort(arr);
		result = new int[N];
		int targetIdx = -1;
		int targetValue = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			P p = arr.get(i);
			if(targetValue != p.value) {
				targetIdx++;
				targetValue = p.value;
			}
			result[p.idx] = targetIdx;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}