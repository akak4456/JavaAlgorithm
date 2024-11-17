import java.io.*;
import java.util.*;
public class Main {
	private static int A, B, C;
	private static int solve(int num, int pow, int mod) {
		int ret = 1;
		if(pow == 0){
			return 1;
		}
		if(pow % 2 == 0) {
			int t = solve(num,pow/2,mod);
			ret = (ret * t) % mod;
			ret = (ret * t) % mod;
		} else {
			ret = (num * solve(num, pow - 1, mod)) % mod;
		}
		return ret % mod;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		System.out.println(solve(A,B,C));
	}
}