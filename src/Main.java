import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static char[][] board;
    private static void solve(int startRow, int startCol, int n) {
        if(n == 3) {
            board[startRow][startCol + 2] = '*';
            board[startRow + 1][startCol + 1] = '*';
            board[startRow + 1][startCol + 3] = '*';
            for(int i=0;i<5;i++) {
                board[startRow + 2][startCol + i] = '*';
            }
            return;
        }
        solve(startRow, startCol + n / 2, n / 2);
        solve(startRow + n / 2, startCol, n / 2);
        solve(startRow + n / 2, startCol + n, n / 2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N * 2];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N * 2;j++) {
                board[i][j] = ' ';
            }
        }
        solve(0, 0, N);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            for(int j=0;j<N*2;j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}