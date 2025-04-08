import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static int[][] board;
    private static int[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N ][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[3];
        for(int i=0;i<N;i++) {
            int left = board[i][0] + Math.max(dp[0], dp[1]);
            int mid = board[i][1] + Math.max(Math.max(dp[0], dp[1]), dp[2]);
            int right = board[i][2] + Math.max(dp[1], dp[2]);
            dp[0] = left;
            dp[1] = mid;
            dp[2] = right;
        }
        System.out.print(Math.max(dp[0], Math.max(dp[1], dp[2])) + " ");
        dp = new int[3];
        for(int i=0;i<N;i++) {
            int left = board[i][0] + Math.min(dp[0], dp[1]);
            int mid = board[i][1] + Math.min(Math.min(dp[0], dp[1]), dp[2]);
            int right = board[i][2] + Math.min(dp[1], dp[2]);
            dp[0] = left;
            dp[1] = mid;
            dp[2] = right;
        }
        System.out.println(Math.min(dp[0], Math.min(dp[1], dp[2])));
    }

}