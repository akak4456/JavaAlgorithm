import java.io.*;
import java.util.*;

class MainPair implements Comparable<MainPair> {
	int x;
	int y;

	public MainPair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(MainPair o) {
		if(this.x == o.x) {
			return Integer.compare(this.y, o.y);
		}
		return Integer.compare(this.x, o.x);
	}

}

public class Main {
	private static int N;
	private static MainPair[] arr;
	public static void main(String[] args) throws Exception {
		// 입력 최적화를 위해서 Scanner 대신에 BufferedReader, StringTokenizer 를
		// 혼합하는 방식으로 사용함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new MainPair[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			arr[i] = new MainPair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			System.out.println(arr[i].x + " " + arr[i].y);
		}
	}
}