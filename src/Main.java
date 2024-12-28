import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int G;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(br.readLine());
		if(90 <= G && G <= 100) {
			System.out.println("A");
		} else if(80 <= G && G < 90) {
			System.out.println("B");
		} else if(70 <= G && G < 80) {
			System.out.println("C");
		} else if(60 <= G && G < 70) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}
}