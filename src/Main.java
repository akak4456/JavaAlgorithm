import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] board;
    private static int[][] dp;
    private static int solve(int row, int col) {
        if(row == n) return 0;
        int ret = dp[row][col];
        if(ret != -1) return ret;
        ret = board[row][col] + Math.max(solve(row + 1, col) , solve(row + 1, col + 1));
        dp[row][col] = ret;
        return ret;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<=i;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solve(0,0));
    }

}