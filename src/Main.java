import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    private static long N;
    private static final long MOD = 1_000_000_007;
    private static Map<Long, Long> cache = new HashMap<>();
    private static long fib(long n) {
        if(cache.containsKey(n)) {
            return cache.get(n);
        }
        long k = 0L;
        if(n % 2 == 0) {
            k = n / 2;
        } else {
            k = (n - 1) / 2;
        }
        long ret = ((fib(k) * fib(n - k + 1)) % MOD + (fib(k - 1) * fib(n - k)) % MOD) % MOD;
        cache.put(n, ret);
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        long first = 0;
        long second = 1;
        cache.put(0L, 0L);
        cache.put(1L, 1L);
        for(long i=2;i<=1000000;i++) {
            long tmp = (first + second) % MOD;
            cache.put(i, tmp);
            first = second;
            second = tmp;
        }
        System.out.println(fib(N));
    }
}