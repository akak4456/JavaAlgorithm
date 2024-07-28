import java.io.*;
import java.util.*;
class Node implements Comparable<Node> {
	int a;
	int b;


	@Override
	public int compareTo(Node o) {
		return Integer.compare(a, o.a);
	}

	@Override
	public String toString() {
		return "Node{" +
				"a=" + a +
				", b=" + b +
				'}';
	}
}

/**
 * 가장 긴 부분증가수열(어떤 임의의 수열이 주어질 때, 이 수열에서 몇 개의 수들을 제거해서 부분수열을 만들 수 있다.
 * 이때 만들어진 부분수열 중 오름차순으로 정렬된 가장 긴 수열을 최장 증가 부분 수열이라 한다.) 을 구하는 가장 효율적인 알고리즘
 */
class LIS {
	private final int[] origin;
	private int LISLength;
	/**
	 * origin[i] 가 LIS 에 속하면 isIncludedToLIS[i] = true, 아니면 false 가 된다.
	 */
	private boolean[] isIncludedToLIS;
	public LIS(int[] origin) {
		this.origin = origin;
		this.LISLength = 0;
		isIncludedToLIS = null;
	}
	private int lowerBound(int[] array, int start, int end, int value) {
		int low = start;
		int high = end;
		while (low < high) {
			int mid = (low + high) / 2;
			if (array[mid] < value) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	public int getLISLength() {
		if(isIncludedToLIS == null) {
			calc();
		}
		return LISLength;
	}
	public boolean[] getIsIncludedToLIS() {
		if(isIncludedToLIS == null) {
			calc();
		}
		return isIncludedToLIS;
	}
	private void calc() {
		int[] dest = new int[origin.length];
		int[] result = new int[origin.length];
		dest[0] = origin[0];
		int size = 1;
		for (int i = 1; i < origin.length; i++) {
			int index = lowerBound(dest, 0, size, origin[i]);
			dest[index] = origin[i];
			result[i] = index;
			if (index == size) size++;
		}

		int s = size - 1, i = origin.length-1;
		boolean[] vtd = new boolean[origin.length];
		while (s >= 0) {
			if (result[i] == s) {
				vtd[i] = true;
				s--;
			}
			i--;
		}
		this.LISLength = size;
		this.isIncludedToLIS = vtd;
	}
}

public class Main {
	private static int N;
	private static Node[] nodes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine().trim());
		nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			nodes[i] = new Node();
			nodes[i].a = Integer.parseInt(st.nextToken());
			nodes[i].b = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nodes);

		int[] bArray = new int[N];
		for(int i=0;i<N;i++) {
			bArray[i] = nodes[i].b;
		}

		LIS lis = new LIS(bArray);
		int count = 0;
		boolean[] result = lis.getIsIncludedToLIS();
		for (int n = 0; n < N; n++) {
			if (!result[n]) {
				count++;
				sb.append(nodes[n].a).append("\n");
			}
		}
		System.out.println(count);
		if (count > 0) {
			sb.setLength(sb.length()-1);
			System.out.println(sb);
		}
	}
}