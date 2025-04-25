import java.io.*;
import java.util.*;
class Pt {
    int row;
    int col;
    public Pt(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
public class Main {
    private static int N;
    private static int col[];
    private static int result = 0;
    private static boolean promising(int i) {
        for(int j=0;j<i;j++) {
            if(col[j] == col[i] || Math.abs(col[j] - col[i]) == (i - j)) {
                return false;
            }
        }
        return true;
    }
    private static void solve(int i) {
        if(i == N) {
            result += 1;
        } else {
            for(int j=0;j<N;j++) {
                col[i] = j;
                if(promising(i)) {
                    solve(i + 1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N];
        solve(0);
        System.out.println(result);
    }
}