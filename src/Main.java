import java.io.*;
import java.util.*;
class Node {
	char ch;
	Node left, right;
}
public class Main {
	private static int T;
	private static int N;
	private static int[][] board;
	private static int[][] dp;
	private static int solve(int colIdx, int caseNo) {
		if(colIdx == N) {
			return 0;
		}
		if(dp[colIdx][caseNo] != -1) return dp[colIdx][caseNo];
		// caseNo 0: 위아래 떼기 가능하다
		// caseNo 1: 위만 떼는 것이 가능하다
		// caseNo 2: 아래만 떼는 것이 가능하다
		int ret = solve(colIdx + 1, 0);
		if(caseNo == 0 || caseNo == 1) {
			ret = Math.max(ret, board[0][colIdx] + solve(colIdx + 1, 2));
		}
		if(caseNo == 0 || caseNo == 2) {
			ret = Math.max(ret, board[1][colIdx] + solve(colIdx + 1, 1));
		}
		dp[colIdx][caseNo] = ret;
		return ret;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			N = Integer.parseInt(br.readLine());
			board = new int[2][N];
			dp = new int[N][3];
			for(int i=0;i<N;i++) {
				for(int j=0;j<3;j++) {
					dp[i][j] = -1;
				}
			}
			for(int row=0;row<2;row++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int col=0;col<N;col++) {
					board[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println(solve(0,0));
		}
	}
}