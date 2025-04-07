import java.io.*;
import java.util.*;
public class Main {
    private static int T;
    private static int n;
    private static int[][] board;
    private static int[][] dp;
    private static int solve(int state, int col) {
        // state == 0 col 에서 위 아래 스티커 모두 성하다
        // state == 1 col 에서 위 스티커만 있다
        // state == 2 col 에서 아래 스티커만 있다.
        if(col == n) {
            return 0;
        }
        int ret = dp[state][col];
        if(ret != -1) return ret;
        ret = solve(0, col + 1);
        if(state == 0) {
            ret = Math.max(ret, board[1][col] + solve(1, col + 1)); // 아래 스티커 선택
            ret = Math.max(ret, board[0][col] + solve(2, col + 1)); // 위 스티커 선택
        } else if(state == 1) {
            ret = Math.max(ret, board[0][col] + solve(2, col + 1)); // 위 스티커 선택
        } else if(state == 2) {
            ret = Math.max(ret, board[1][col] + solve(1, col + 1)); // 아래 스티커 선택
        }
        dp[state][col] = ret;
        return ret;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int testCase = 0; testCase < T; testCase++) {
            n = Integer.parseInt(br.readLine());
            board = new int[2][n];
            for(int i=0;i<2;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j=0;j<n;j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp = new int[3][n];
            for(int i=0;i<3;i++) {
                Arrays.fill(dp[i], -1);
            }
            System.out.println(solve(0,0));
        }
    }

}