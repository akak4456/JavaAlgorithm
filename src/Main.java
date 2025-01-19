import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static boolean is666(int num) {
		String s = Integer.toString(num);
		for(int i=0;i<s.length()-2;i++) {
			if(s.charAt(i) == '6' && s.charAt(i+1) == '6' && s.charAt(i+2) == '6') {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int cur = 0;
		for(int i = 1; ;i++) {
			if(is666(i)) {
				cur++;
				if(cur == N) {
					System.out.println(i);
					break;
				}
			}
		}
	}
}