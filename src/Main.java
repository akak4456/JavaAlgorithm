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
		arr = new int[8];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<8;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean isAscending = true;
		for(int i=0;i<8;i++) {
			if(arr[i] != i+1) {
				isAscending = false;
				break;
			}
		}
		boolean isDescending = true;
		for(int i=0;i<8;i++) {
			if(arr[i] != 8-i) {
				isDescending = false;
				break;
			}
		}
		if (isAscending) {
			System.out.println("ascending");
		}else if(isDescending) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
}