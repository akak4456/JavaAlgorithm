import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class P {
	int col;
	int row;
	public P(int row, int col) {
		this.col = col;
		this.row = row;
	}
}
public class Main {
	private static int N;
	private static int[] arr;
	private static int[] cnt;
	private static int kind;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		cnt = new int[10];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int maxCnt = 0;
		while(start < N && end < N) {
			if(kind < 2) {
				if(cnt[arr[end]] == 0) {
					kind++;
				}
				cnt[arr[end]]++;
				end++;
			} else {
				if(cnt[arr[end]] == 0) {
					cnt[arr[start]]--;
					if(cnt[arr[start]] == 0) {
						kind--;
					}
					start++;
				} else {
					cnt[arr[end]]++;
					end++;
				}
			}
			maxCnt = Math.max(maxCnt, end - start);
		}
		maxCnt = Math.max(maxCnt, end - start);
		System.out.println(maxCnt);
	}
}