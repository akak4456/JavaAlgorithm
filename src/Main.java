import java.io.*;
import java.util.*;
public class Main {
    private static int N, M;
    private static int[][] board;
    private static int result = 987654321;
    private static void solve(int idx) {
        int newIdx = idx;
        while(newIdx < N * N) {
            int row = newIdx / N;
            int col = newIdx % N;
            if(board[row][col] == 2) {
                board[row][col] = 0;
                solve(newIdx + 1);
                board[row][col] = 2;
            }
            newIdx++;
        }
        int chickenCount = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(board[i][j] == 2) {
                    chickenCount++;
                }
            }
        }
        if(chickenCount == 0 || chickenCount > M) return;
        int res = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(board[i][j] == 1) {
                    int minDist = Integer.MAX_VALUE;
                    for(int k=0;k<N;k++) {
                        for(int l=0;l<N;l++) {
                            if(board[k][l] == 2) {
                                minDist = Math.min(minDist, Math.abs(i - k) + Math.abs(j - l));
                            }
                        }
                    }
                    res += minDist;
                }
            }
        }
        result = Math.min(result, res);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0);
        System.out.println(result);
    }

}