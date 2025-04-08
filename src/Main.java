import java.io.*;
import java.util.*;
public class Main {
    private static int N, K;
    private static int[] W;
    private static int[] V;
    private static int[][] dp;
    private static int solve(int pos, int remainWeight) {
        if(pos >= N) return 0;
        if(remainWeight <= 0) return 0;
        int ret = dp[pos][remainWeight];
        if(ret != -1) return ret;
        ret = solve(pos + 1, remainWeight);
        if(remainWeight >= W[pos]) {
            ret = Math.max(ret, solve(pos + 1, remainWeight - W[pos]) + V[pos]);
        }
        dp[pos][remainWeight] = ret;
        return ret;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        W = new int[N];
        V = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N][K + 1];
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(solve(0, K));
    }

}