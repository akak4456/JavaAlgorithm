import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static int[][] board;
    private static int[][][] dp;
    private static int solve(int row, int col, int type) {
        // System.out.println(row + " " + col + " " + type);
        if(row == N - 1 && col == N - 1) {
            return 1;
        }
        int ret = dp[row][col][type];
        if(ret != -1) return ret;
        ret = 0;
        //type == 0: 가로 type == 1: 세로 type == 2: 대각선
        if((type == 0 || type == 2) && col + 1 < N && board[row][col + 1] == 0) {
            board[row][col + 1] = 1;
            ret += solve(row, col + 1, 0);
            board[row][col + 1] = 0;
        }
        if((type == 1 || type == 2) && row + 1 < N && board[row + 1][col] == 0) {
            board[row + 1][col] = 1;
            ret += solve(row + 1, col, 1);
            board[row + 1][col] = 0;
        }
        if((type == 0 || type == 1 || type == 2) && row + 1 < N && col + 1 < N && board[row][col + 1] == 0 && board[row + 1][col] == 0 && board[row + 1][col + 1] == 0) {
            board[row][col + 1] = 1;
            board[row + 1][col] = 1;
            board[row + 1][col + 1] = 1;
            ret += solve(row + 1, col + 1, 2);
            board[row][col + 1] = 0;
            board[row + 1][col] = 0;
            board[row + 1][col + 1] = 0;
        }
        dp[row][col][type] = ret;
        return ret;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        dp = new int[N][N][3];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<N;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                for(int k=0;k<3;k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        board[0][0] = 1;
        board[0][1] = 1;
        solve(0,1,0);
        System.out.println(dp[0][1][0]);
    }

}