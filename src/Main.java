import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;
    private static int[][] dp;
	private static int solve(int startIdx, int curMinValue) {
        if(startIdx == N) return 0;
        int ret = dp[startIdx][curMinValue];
        if(ret != -1) return ret;
        ret = solve(startIdx + 1, curMinValue);
        if(arr[startIdx] > curMinValue) {
            ret = Math.max(ret, solve(startIdx + 1, arr[startIdx]) + 1);
        }
        dp[startIdx][curMinValue] = ret;
        return ret;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N][1000 + 1];
        for(int i=0;i<N;i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(solve(0, 0));
    }

}