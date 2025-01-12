import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int S, M, L, XL, XXL, XXXL;
	private static int T, P;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		XL = Integer.parseInt(st.nextToken());
		XXL = Integer.parseInt(st.nextToken());
		XXXL = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		T = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		int shirtCnt = 0;
		shirtCnt += (int)Math.ceil(S * 1.0 / T);
		shirtCnt += (int)Math.ceil(M * 1.0 / T);
		shirtCnt += (int)Math.ceil(L * 1.0 / T);
		shirtCnt += (int)Math.ceil(XL * 1.0 / T);
		shirtCnt += (int)Math.ceil(XXL * 1.0 / T);
		shirtCnt += (int)Math.ceil(XXXL * 1.0 / T);
		System.out.println(shirtCnt);
		System.out.println(N / P + " " + N % P);
	}
}