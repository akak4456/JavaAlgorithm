import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int Y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Y = Integer.parseInt(br.readLine());
		if(Y % 4 == 0 && Y % 100 != 0) {
			System.out.println(1);
		} else if(Y % 400 == 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}