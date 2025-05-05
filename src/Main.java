import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] board;
    private static int[] drow = {-1, 1, 0,0};
    private static int[] dcol = {0,0,-1,1};
    private static boolean isExposed(int row, int col) {
        if(board[row][col] != 1) return false;
        int sum = 0;
        for(int i=0;i<4;i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= M) continue;
            if(board[nrow][ncol] == 2) sum++;
        }
        return sum >= 2;
    }
    private static void markOuterAir(int row, int col) {
        if(board[row][col] != 0) return;
        board[row][col] = 2;
        for(int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= M) continue;
            if(board[nrow][ncol] == 0) markOuterAir(nrow, ncol);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        markOuterAir(0, 0);
        int time = 0;
        while(true) {
            boolean isCheeseExist = false;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(isExposed(i, j)) {
                        isCheeseExist = true;
                        board[i][j] = -1;
                    }
                }
            }
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(board[i][j] == -1) {
                        board[i][j] = 0;
                        markOuterAir(i, j);
                    }
                }
            }
            if(!isCheeseExist) break;
            time++;
        }
        System.out.println(time);
    }
}