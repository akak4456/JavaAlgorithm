import java.io.*;
import java.util.*;

public class Main {
	private static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int testCase = 0; testCase < T; testCase++) {
			String line = br.readLine();
			Stack<Character> st = new Stack<>();
			boolean isPossible = true;
			for(int i = 0; i < line.length(); i++) {
				if(line.charAt(i) == '(') {
					st.push(line.charAt(i));
				}
				if(line.charAt(i) == ')') {
					if(st.isEmpty()) {
						isPossible = false;
						break;
					}
					st.pop();
				}
			}
			if(!st.isEmpty()) {
				isPossible = false;
			}
			if(isPossible) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}