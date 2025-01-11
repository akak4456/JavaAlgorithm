import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	private static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[42];
		for(int i = 0; i < 10; i++) {
			int a = Integer.parseInt(br.readLine());
			arr[a % 42]++;
		}
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}