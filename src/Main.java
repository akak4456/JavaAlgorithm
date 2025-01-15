import java.io.*;
import java.util.*;

public class Main {
	private static int L;
	private static String line;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		line = br.readLine();
		long result = 0;
		long p = 1;
		final int M = 1234567891;
		for(int i=0;i<L;i++) {
			result = (result + (line.charAt(i) - 'a' + 1) * p) % M;
			p = (p * 31) % M;
		}
		System.out.println(result);
	}
}