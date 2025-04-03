import java.io.*;
import java.util.*;

public class Main {
    private static int A, B;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        boolean isPossible = true;
        int cnt = 0;
        while(B > A) {
            if(B % 2 == 0) {
                cnt++;
                B /= 2;
            } else if(B % 10 == 1) {
                cnt++;
                B /= 10;
            } else {
                isPossible = false;
                break;
            }
        }
        if(isPossible && A == B) {
            System.out.println(cnt + 1);
        } else {
            System.out.println(-1);
        }
    }

}