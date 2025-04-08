import java.io.*;
import java.util.*;
public class Main {
    private static String str1;
    private static String str2;
    private static int[][] dp; // dp[i][j] = str1 의 (i..) str2 의 (j..) 의 LCS
    public static int solve(int str1Idx, int str2Idx) {
        if(str1Idx == str1.length() || str2Idx == str2.length()) {
            return 0;
        }
        int ret = dp[str1Idx][str2Idx];
        if(ret != -1) return ret;
        ret = solve(str1Idx + 1, str2Idx);
        ret = Math.max(ret, solve(str1Idx, str2Idx + 1));
        if(str1.charAt(str1Idx) == str2.charAt(str2Idx)) {
            ret = Math.max(ret, solve(str1Idx + 1, str2Idx + 1) + 1);
        }
        dp[str1Idx][str2Idx] = ret;
        return ret;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();
        dp = new int[str1.length()][str2.length()];
        for(int i = 0; i < str1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(solve(0,0));
    }

}