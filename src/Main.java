import java.io.*;
import java.util.*;

class IntKeyPair<V> implements Comparable<IntKeyPair<V>> {
	private int first;
	private V second;

	public IntKeyPair(int first, V second) {
		this.first = first;
		this.second = second;
	}

	public int getFirst() {
		return first;
	}

	public V getSecond() {
		return second;
	}

	@Override
	public int compareTo(IntKeyPair<V> o) {
		return Integer.compare(this.first, o.first);
	}

}

public class Main {
	private static int N;
	private static IntKeyPair<String>[] arr;
	public static void main(String[] args) throws Exception {
		// 입력 최적화를 위해서 Scanner 대신에 BufferedReader, StringTokenizer 를
		// 혼합하는 방식으로 사용함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new IntKeyPair[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			arr[i] = new IntKeyPair<String>(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			System.out.println(arr[i].getFirst() + " " + arr[i].getSecond());
		}
	}
}