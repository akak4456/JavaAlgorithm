import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 0 && b == 0 && c == 0) break;
			if(c < a) {
				int tmp = a;
				a = c;
				c = tmp;
			}
			if(c < b) {
				int tmp = b;
				b = c;
				c = tmp;
			}
			if(a * a + b * b == c * c) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}
}