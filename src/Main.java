import java.io.*;
import java.util.*;
class Node {
	int startIdx;
	int moreValue;

	Node(int startIdx, int moreValue) {
		this.startIdx = startIdx;
		this.moreValue = moreValue;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Node node = (Node) o;
		return startIdx == node.startIdx && moreValue == node.moreValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(startIdx, moreValue);
	}
}
public class Main {
	private static int N;
	private static int A[];
	private static int D[];
	private static int X[];
	private static int curXSize;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		D = new int[N + 1];
		X = new int[N + 1];
		curXSize = 1;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1;i<=N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=1;i<=N;i++) {
			if(A[i] > X[curXSize - 1]) {
				X[curXSize] = A[i];
				D[i] = curXSize;
				curXSize++;
			} else {
				int startIdx = 0;
				int endIdx = curXSize - 1;
				while(startIdx < endIdx) {
					int mid = (startIdx + endIdx) / 2;
					if(X[mid] >= A[i]) {
						endIdx = mid;
					} else {
						startIdx = mid + 1;
					}
				}
				X[endIdx] = A[i];
				D[i] = endIdx;
			}
		}

		int ans = 0;
		for(int i=0;i<=N;i++) {
			if(D[i] > ans) {
				ans = D[i];
			}
		}
		System.out.println(ans);
	}
}