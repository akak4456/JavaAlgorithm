import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int R, C, T;
    private static int[][] board;
    private static int[] drow = {-1,1,0,0};
    private static int[] dcol = {0,0,-1,1};
    private static int upperRow = -1;
    private static int lowerRow = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == -1) {
                    if(upperRow == -1) {
                        upperRow = i;
                    } else {
                        lowerRow = i;
                    }
                }
            }
        }
        for(int time = 0; time < T; time++) {
            // 미세먼지가 확산된다.
            int[][] dBoard = new int[R][C];
            for(int i=0;i<R;i++) {
                for(int j=0;j<C;j++) {
                    if(board[i][j] > 0) {
                        int amount = board[i][j] / 5;
                        int spreadDirectionCnt = 0;
                        for(int t=0;t<4;t++) {
                            int nrow = i + drow[t];
                            int ncol = j + dcol[t];
                            if(nrow < 0 || nrow >= R || ncol < 0 || ncol >= C) continue;
                            if(board[nrow][ncol] == -1) continue;
                            dBoard[nrow][ncol] += amount;
                            spreadDirectionCnt++;
                        }
                        dBoard[i][j] -= amount * spreadDirectionCnt;
                    }
                }
            }
            for(int i=0;i<R;i++) {
                for(int j=0;j<C;j++) {
                    if(board[i][j] == -1) continue;
                    board[i][j] += dBoard[i][j];
                }
            }
            // 공기청정기가 작동한다.
            // 윗부분 작동
            for(int row = upperRow - 2; row >= 0; row--) {
                board[row + 1][0] = board[row][0];
            }
            for(int col = 1; col < C; col++) {
                board[0][col - 1] = board[0][col];
            }
            for(int row = 1; row <= upperRow; row++) {
                board[row - 1][C - 1] = board[row][C - 1];
            }
            for(int col = C - 2; col >= 1; col--) {
                board[upperRow][col + 1] = board[upperRow][col];
            }
            board[upperRow][1] = 0;
            // 아랫부분 작동
            for(int row = lowerRow + 2; row < R; row++) {
                board[row - 1][0] = board[row][0];
            }
            for(int col = 1; col < C; col++) {
                board[R - 1][col - 1] = board[R - 1][col];
            }
            for(int row = R - 2; row >= lowerRow; row--) {
                board[row + 1][C - 1] = board[row][C - 1];
            }
            for(int col = C - 2; col >= 1; col--) {
                board[lowerRow][col + 1] = board[lowerRow][col];
            }
            board[lowerRow][1] = 0;
        }
        int remain = 0;
        for(int row = 0; row < R; row++) {
            for(int col = 0; col < C; col++) {
                if(board[row][col] > 0) {
                    remain+=board[row][col];
                }
            }
        }
        System.out.println(remain);
    }
}