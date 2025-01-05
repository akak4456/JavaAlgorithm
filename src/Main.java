import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	private static int A, B, C;
	private static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		String result = A * B * C + "";
		arr = new int[10];
		for(int i=0;i<result.length();i++) {
			arr[result.charAt(i) - '0']++;
		}
		for(int i=0;i<10;i++) {
			System.out.println(arr[i]);
		}
	}
}