import java.io.*;
import java.util.*;

public class Main {
    private static int A, B, C;
    private static Map<Integer, Long> map = new HashMap<>();
    private static long solve(int b) {
        if(map.containsKey(b)) {return map.get(b);}
        if(b == 1) {
            return A;
        }
        long ret = 0;
        if(b % 2 == 0) {
            ret = (solve(b/2) * solve(b/2)) % C;
        } else {
            ret = (A * solve(b - 1)) % C;
        }
        map.put(b, ret);
        return ret;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.println(solve(B) % C);
    }

}