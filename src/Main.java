import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] A;
    private static int M;
    private static int[] B;
    private static ArrayList<Integer> result;
    private static void solve(int aStartIdx, int bStartIdx) {
        if(aStartIdx >= N || bStartIdx >= M) return;
        int maxVal = 0;
        int aNext = 0;
        int bNext = 0;
        for(int aIdx = aStartIdx; aIdx < N; aIdx++) {
            for(int bIdx = bStartIdx; bIdx < M; bIdx++) {
                if(A[aIdx] == B[bIdx] && maxVal < A[aIdx]) {
                    maxVal = A[aIdx];
                    aNext = aIdx;
                    bNext = bIdx;
                    break;
                }
            }
        }
        if(maxVal != 0) {
            result.add(maxVal);
            solve(aNext + 1, bNext + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        result = new ArrayList<>();
        solve(0,0);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}