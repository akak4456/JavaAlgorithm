import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String line = br.readLine();
			if(line.equals("0")) {
				break;
			}
			int left = 0, right = line.length() - 1;
			boolean isYes = true;
			while(left <= right) {
				if(line.charAt(left) != line.charAt(right)) {
					isYes = false;
					break;
				}
				left++;
				right--;
			}
			if(isYes) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}