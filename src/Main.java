import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static long B;
    private static int[][] A;
    private static int[][] mul(int[][] a, int[][] b) {
        int[][] result = new int[N][N];
        for(int row = 0; row < N; row++) {
            for(int col = 0; col < N; col++) {
                int sum = 0;
                for(int i=0;i<N;i++) {
                    sum += a[row][i] * b[i][col];
                    sum %= 1000;
                }
                result[row][col] = sum % 1000;
            }
        }
        return result;
    }
    private static Map<Long, int[][]> cache = new HashMap<>();
    private static int[][] pow(int[][] a, long b) {
        if(b == 1) {
            return a;
        }
        int[][] result = cache.get(b);
        if(result != null) return result;
        if (b % 2 == 0) {
            result = mul(pow(a, b/2), pow(a, b/2));
        } else {
            result = mul(pow(a, b - 1), a);
        }
        cache.put(b, result);
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        A = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] result = pow(A, B);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print((anInt % 1000) + " ");
            }
            System.out.println();
        }
    }
}