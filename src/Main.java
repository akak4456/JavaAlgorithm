import java.io.*;
import java.util.*;

public class Main {
	private static int A, B, V;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		int days = (int)Math.ceil((double)(V - A) / (A - B));
		System.out.println(days + 1);
	}
}