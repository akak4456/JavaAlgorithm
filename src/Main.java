import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static Deque<Integer> queue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		queue = new LinkedList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			switch(st.nextToken()) {
				case "push":
					queue.add(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					if(queue.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(queue.poll());
					}
					break;
				case "size":
					System.out.println(queue.size());
					break;
				case "empty":
					System.out.println(queue.isEmpty() ? 1 : 0);
					break;
				case "front":
					if(queue.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(queue.peek());
					}
					break;
				case "back":
					if(queue.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(queue.getLast());
					}
					break;
			}
		}
	}
}