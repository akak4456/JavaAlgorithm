import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	private static int pos[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pos = new int[26];
		for(int i=0;i<26;i++) {
			pos[i] = -1;
		}
		String line = br.readLine();
		for(int i=0;i<line.length();i++) {
			int idx = line.charAt(i) - 'a';
			if(pos[idx] == -1) {
				pos[idx] = i;
			}
		}
		for(int i=0;i<26;i++) {
			System.out.print(pos[i] + " ");
		}
		System.out.println();
	}
}