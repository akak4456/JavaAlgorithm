import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int X, Y, D, T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		double dist = Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
		double minValue = Math.min(dist, T + Math.abs(dist - D));
		int jumpCnt = 2;
		while(dist > D * jumpCnt) {
			minValue = Math.min(minValue, T * jumpCnt + Math.abs(dist- D * jumpCnt));
			jumpCnt++;
		}
		minValue = Math.min(minValue, T * jumpCnt);
		System.out.println(minValue);
	}
}