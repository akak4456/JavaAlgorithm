import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	private static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int testCase = 0; testCase < T; testCase++) {
			String line = br.readLine();
			int scores = 0;
			int score = 0;
			for(int i=0;i<line.length();i++) {
				if(line.charAt(i) == 'O') {
					score++;
				} else {
					score = 0;
				}
				scores += score;
			}
			System.out.println(scores);
		}
	}
}