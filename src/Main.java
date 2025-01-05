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
		arr = new int[9];
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int maxVal = 0;
		int maxIdx = -1;
		for(int i=0;i<9;i++) {
			if(arr[i] > maxVal) {
				maxVal = arr[i];
				maxIdx = i;
			}
		}
		System.out.println(maxVal);
		System.out.println(maxIdx + 1);
	}
}