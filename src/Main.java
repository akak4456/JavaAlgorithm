import java.io.*;
import java.util.*;

public class Main {
    private static int R, C;
    private static char[][] board;
    private static int result = 0;
    private static boolean[][] visited;
    private static int[] drow = {-1,1,0,0};
    private static int[] dcol = {0,0,-1,1};
    private static void solve(int row, int col, int used, int cnt) {
        result = Math.max(result, cnt);
        visited[row][col] = true;
        for(int i=0;i<4;i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow < 0 || nrow >= R || ncol < 0 || ncol >= C) continue;
            if(visited[nrow][ncol]) continue;
            if((used & (1 << (board[nrow][ncol] - 'A'))) > 0) continue;
            solve(nrow, ncol, used | (1 << (board[nrow][ncol] - 'A')), cnt + 1);
        }
        visited[row][col] = false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        visited[0][0] = true;
        solve(0,0,1 << (board[0][0] - 'A'), 1);
        System.out.println(result);
    }
}