import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static Stack<Integer> stack;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stack = new Stack<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken()) {
				case "push":
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					if(stack.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(stack.pop());
					}
					break;
				case "size":
					System.out.println(stack.size());
					break;
				case "empty":
					System.out.println(stack.isEmpty() ? 1 : 0);
					break;
				case "top":
					if(stack.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(stack.peek());
					}
					break;
			}
		}
	}
}