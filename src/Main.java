import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int result = Integer.MAX_VALUE;
		int fiveCnt = 0;
		while(N > 0) {
			if(N % 3 == 0) {
				result = Math.min(result, fiveCnt + N / 3);
			}
			N -= 5;
			fiveCnt++;
		}
		if(N == 0) {
			result = Math.min(result, fiveCnt);
		}
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}
}