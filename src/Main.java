import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class GraphPair {
    int row;
    int col;
    public GraphPair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {
    private static int N, M;
    private static int[][] board;
    private static boolean[][] visited;
    private static int result = 0;
    private static int[] drow = {-1,1,0,0};
    private static int[] dcol = {0,0,-1,1};
    private static void spread(int[][] spreadBoard) {
        Queue<GraphPair> pairs = new LinkedList<GraphPair>();
        for(int row = 0; row < N; row++) {
            for(int col = 0; col < M; col++) {
                if(spreadBoard[row][col] == 2) {
                    pairs.add(new GraphPair(row, col));
                }
            }
        }
        while(!pairs.isEmpty()) {
            GraphPair pair = pairs.poll();
            if(spreadBoard[pair.row][pair.col] == 1) continue;
            spreadBoard[pair.row][pair.col] = 1;
            for(int i=0;i<4;i++) {
                int nrow = pair.row + drow[i];
                int ncol = pair.col + dcol[i];
                if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= M) continue;
                if(spreadBoard[nrow][ncol] != 0) continue;
                pairs.add(new GraphPair(nrow, ncol));
            }
        }
        int cnt = 0;
        for(int row = 0; row < N; row++) {
            for(int col = 0; col < M; col++) {
                if(spreadBoard[row][col] == 0) {
                    cnt++;
                }
            }
        }
        result = Math.max(result, cnt);
    }
    private static void makeWallAndSpread(int curCnt) {
        if(curCnt == 3) {
            int[][] spreadBoard = new int[N][M];
            for(int row = 0; row < N; row++) {
                for(int col = 0; col < M; col++) {
                    spreadBoard[row][col] = board[row][col];
                }
            }
            spread(spreadBoard);
            return;
        }
        for(int row = 0; row < N; row++) {
            for(int col = 0; col < M; col++) {
                if(board[row][col] == 0) {
                    board[row][col] = 1;
                    makeWallAndSpread(curCnt + 1);
                    board[row][col] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        makeWallAndSpread(0);
        System.out.println(result);
    }
}