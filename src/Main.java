import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static int T;
	private static int n;
	private static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testCase = 0; testCase < T; testCase++) {
			n = Integer.parseInt(br.readLine());
			Map<String, List<String>> m = new HashMap<>();
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String wear = st.nextToken();
				String wearKind = st.nextToken();
				m.putIfAbsent(wearKind, new ArrayList<>());
				m.get(wearKind).add(wear);
			}
			List<Integer> l = new ArrayList<>();
			for (Map.Entry<String, List<String>> entry : m.entrySet()) {
				l.add(entry.getValue().size());
			}
			dp = new int[l.size()][l.size()];
			for(int i=0;i<l.size();i++) {
				dp[0][i] = l.get(i);
			}
			for(int i=1;i<l.size();i++) {
				for(int j=0;j<l.size();j++) {
					for(int k=j+1;k<l.size();k++) {
						dp[i][j] += l.get(j) * dp[i-1][k];
					}
				}
			}
			int result = 0;

			for(int i=0;i<l.size();i++) {
				for(int j=0;j<l.size();j++) {
					result += dp[i][j];
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}