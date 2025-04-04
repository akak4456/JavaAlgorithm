import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] arr;
    private static int[][] dp;
    private static int solve(int homeNumber, int colorNumber) {
        if(homeNumber == N) {
            return 0;
        }
        int ret = dp[homeNumber][colorNumber];
        if(ret != -1) return ret;
        ret = 987654321;
        for(int i=0;i<3;i++) {
            if(i == colorNumber) continue;
            ret = Math.min(ret, solve(homeNumber + 1, i) + arr[homeNumber][colorNumber]);
        }
        dp[homeNumber][colorNumber] = ret;
        return ret;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        dp = new int[N][3];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(Math.min(Math.min(solve(0,0), solve(0,1)), solve(0,2)));
    }

}