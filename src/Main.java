import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int w, n;
	private static int arr[];
	private static int cnt[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		cnt = new int[400000 + 1];
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				cnt[arr[i] + arr[j]]++;
			}
		}
		boolean isPossible = false;
		for(int i=0;i<=400000;i++) {
			if(cnt[i] > 0) {
				cnt[i]--;
				if(w - i >= 0 && cnt[w - i] > 0) {
					isPossible = true;
					break;
				}
				cnt[i]++;
			}
		}
		if(isPossible) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}