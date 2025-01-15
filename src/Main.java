import java.io.*;
import java.util.*;

public class Main {
	private static int A,B;
	private static int GCD(int a, int b) {
		if(a < b) {
			return GCD(b, a);
		}
		if(b == 0) {
			return a;
		}
		return GCD(b, a % b);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		int gcd = GCD(A,B);
		System.out.println(gcd);
		int lcm = gcd * (A / gcd) * (B / gcd);
		System.out.println(lcm);
	}
}