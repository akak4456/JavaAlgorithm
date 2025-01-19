import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int twoCnt(int num) {
		int ret = 0;
		while(num > 0) {
			if(num % 2 == 0) {
				ret++;
			} else {
				break;
			}
			num /= 2;
		}
		return ret;
	}
	private static int fiveCnt(int num) {
		int ret = 0;
		while(num > 0) {
			if(num % 5 == 0) {
				ret++;
			} else {
				break;
			}
			num /= 5;
		}
		return ret;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int twoCnt = 0;
		int fiveCnt = 0;
		for(int i=1;i<=N;i++) {
			twoCnt += twoCnt(i);
			fiveCnt += fiveCnt(i);
		}
		System.out.println(Math.min(twoCnt, fiveCnt));
	}
}