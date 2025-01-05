import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	private static int T;
	private static int H, W, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int testCase = 0; testCase < T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int remainH = N;
			int step = 1;
			while(remainH > H) {
				remainH -= H;
				step++;
			}
			if(step < 10) {
				System.out.println(remainH + "0" + step);
			}else{
				System.out.println(remainH + "" + step);
			}
		}
	}
}