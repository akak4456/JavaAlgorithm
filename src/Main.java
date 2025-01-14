import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int step = 1;
		int lastNum = 1;
		while(N > lastNum) {
			lastNum += 6 * step;
			step++;
		}
		System.out.println(step);
	}
}