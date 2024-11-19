import java.io.*;
import java.util.*;
public class Main {
	private static int n;
	private static int[][] board;
	private static int[][] dp;
	private static int solve(int row, int col) {
		if (row == n - 1) {
			return board[row][col];
		}
		if(dp[row][col] != -1) return dp[row][col];
		int ret = board[row][col] + solve(row + 1, col);
		ret = Math.max(ret,board[row][col] + solve(row+1,col+1));
		dp[row][col] = ret;
		return ret;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		dp = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				dp[i][j] = -1;
			}
		}
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(solve(0,0));
	}
}