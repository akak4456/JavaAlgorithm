import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int M;
    private static long[] N;
    private static long[] S;
    private static final long MOD = 1_000_000_007;
    private static Map<Long, Long> cache = new HashMap<>();
    private static long pow(long base, long exp) {
        if(exp == 1) {
            return base;
        }
        if(cache.containsKey(exp)) {
            return cache.get(exp);
        }
        if(exp % 2 == 0) {
            long ret = (pow(base, exp / 2) * pow(base, exp / 2)) % MOD;
            cache.put(exp, ret);
            return ret;
        } else {
            long ret = (base * pow(base, exp - 1)) % MOD;
            cache.put(exp, ret);
            return ret;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        N = new long[M];
        S = new long[M];
        long sum = 0;
        for (int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N[i] = Long.parseLong(st.nextToken());
            S[i] = Long.parseLong(st.nextToken());
            cache.clear();
            sum += (S[i] * pow(N[i], MOD - 2));
            sum %= MOD;
        }
        System.out.println(sum);
    }
}