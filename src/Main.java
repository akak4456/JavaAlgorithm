import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	private static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[5];
		for(int i=0;i<5;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		for(int i=0;i<5;i++) {
			sum += arr[i] * arr[i];
		}
		System.out.println(sum % 10);
	}
}