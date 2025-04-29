import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] A;
    private static int[][][] dp;

    private static int solve(int idx, int lastNum, boolean isAsc) {
        if (idx == N) {
            return 0;
        }
        int ret = dp[idx][lastNum][isAsc ? 0 : 1];
        if (ret != -1) return ret;
        ret = Math.max(isAsc ? solve(idx + 1, lastNum, true) : 0, solve(idx + 1, lastNum, false)); // 아무것도 선택 안했을 때
        if (isAsc) {
            if (A[idx] > lastNum) {
                ret = Math.max(ret, solve(idx + 1, A[idx], true) + 1);
                ret = Math.max(ret, solve(idx + 1, A[idx], false) + 1);
            }
        }
        if (!isAsc) {
            if (lastNum > A[idx]) {
                ret = Math.max(ret, solve(idx + 1, A[idx], false) + 1);
            }
        }
        dp[idx][lastNum][isAsc ? 0 : 1] = ret;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N][1000 + 1 + 1][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 1000 + 1 + 1; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        System.out.println(Math.max(solve(0, 0, true), solve(0, 1001, false)));
    }
}