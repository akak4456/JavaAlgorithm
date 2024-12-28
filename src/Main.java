import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
class ProblemPair {
	int first;
	int second;
	ProblemPair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}
public class Main {
	private static int w, n;
	private static int arr[];
	private static ArrayList<ArrayList<ProblemPair>> cnt;
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
		Arrays.sort(arr);
		cnt = new ArrayList<>();
		for(int i=0;i<=400000;i++) {
			cnt.add(new ArrayList<>());
		}
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(cnt.get(arr[i] + arr[j]).isEmpty()) {
					cnt.get(arr[i] + arr[j]).add(new ProblemPair(i, j));
				}
			}
		}
		boolean isPossible = false;
		for(int i=0;i<=400000;i++) {
			if(w-i>=0 && w-i <= 400000 && !cnt.get(i).isEmpty() && !cnt.get(w - i).isEmpty()) {
				for(int t=0;t<cnt.get(i).size();t++) {
					for(int p=0;p<cnt.get(w - i).size();p++) {
						if (cnt.get(i).get(t).first != cnt.get(w-i).get(p).first &&
								cnt.get(i).get(t).second != cnt.get(w-i).get(p).first &&
								cnt.get(i).get(t).first != cnt.get(w-i).get(p).second &&
								cnt.get(i).get(t).second != cnt.get(w-i).get(p).second
						) {
							isPossible = true;
							break;
						}
					}
					if(isPossible) {
						break;
					}
				}
				if(isPossible) {
					break;
				}
			}
		}
		if(isPossible) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}