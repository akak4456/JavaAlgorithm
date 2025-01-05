import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	private static int T;
	private static int R;
	private static String S;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int testCase = 0; testCase < T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			S = st.nextToken();
			StringBuilder result = new StringBuilder();
			for(int i=0;i<S.length();i++) {
				for(int j=0;j<R;j++) {
					result.append(S.charAt(i));
				}
			}
			System.out.println(result);
		}
	}
}