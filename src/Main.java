import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = br.readLine();
			if(line.equals(".")){
				break;
			}
			boolean isPossible = true;
			Stack<Character> st1 = new Stack<>();
			for(int i = 0; i < line.length(); i++){
				if(line.charAt(i) == '(') {
					st1.push(line.charAt(i));
				}
				if(line.charAt(i) == '[') {
					st1.push(line.charAt(i));
				}
				if(line.charAt(i) == ')') {
					if(st1.isEmpty() || st1.peek() != '(') {
						isPossible = false;
						break;
					}
					st1.pop();
				}
				if(line.charAt(i) == ']') {
					if(st1.isEmpty() || st1.peek() != '[') {
						isPossible = false;
						break;
					}
					st1.pop();
				}
			}
			if(st1.isEmpty() && isPossible){
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}