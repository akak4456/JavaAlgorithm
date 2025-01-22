import java.io.*;
import java.util.*;

public class Main {
	private static int K;
	private static Stack<Integer> st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		st = new Stack<>();
		for(int i=0;i<K;i++) {
			int t = Integer.parseInt(br.readLine());
			if(t == 0) {
				st.pop();
			} else {
				st.push(t);
			}
		}
		int sum = 0;
		while(!st.isEmpty()) {
			sum += st.pop();
		}
		System.out.println(sum);
	}
}