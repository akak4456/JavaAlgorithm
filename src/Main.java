import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
	private static int N, M;
	private static String S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine();
		int startPos = 0;
		int result = 0;
		int count = 0;
		while(startPos < M) {
			// System.out.println(startPos + " " + endPos);
			if(startPos + 3 <= M && S.substring(startPos, startPos + 3).equals("IOI")) {
				count++;
				startPos += 2;
				if(count == N) {
					result++;
					count--;
				}
			} else {
				count = 0;
				startPos++;
			}
		}
		System.out.println(result);
	}
}