import java.io.*;
import java.util.*;

public class Main {
	private static int n;
	private static int arr[];
	private static ArrayList<Character> op;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> stack = new Stack<>();
		int arrPointer = 0;
		op = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			if(stack.isEmpty() || stack.peek() != arr[arrPointer]) {
				stack.push(i);
				op.add('+');
			}
			while(arrPointer < n && !stack.isEmpty() && stack.peek() == arr[arrPointer]) {
				op.add('-');
				arrPointer++;
				stack.pop();
			}
		}
		if(arrPointer == n) {
			StringBuilder sb = new StringBuilder();
            for (Character character : op) {
                sb.append(character);
                sb.append("\n");
            }
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}
}