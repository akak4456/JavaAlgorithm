import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static Deque<Integer> deque;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		deque = new ArrayDeque<>();
		for(int i=1;i<=N;i++) {
			deque.addLast(i);
		}
		while(deque.size() > 1) {
			deque.removeFirst();
			if(deque.size() == 1) {
				break;
			}
			int a = deque.removeFirst();
			deque.addLast(a);
		}
		System.out.println(deque.getFirst());
	}
}