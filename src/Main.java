import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int sum(int n) {
		int ret = n;
		while(n > 0) {
			ret += n % 10;
			n /= 10;
		}
		return ret;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i=0;i<=N;i++) {
			if(sum(i) == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}