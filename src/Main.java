import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

class GraphNode {
    int row;
    int col;
    int curDist;
    boolean isBreakingWallPossible;
    public GraphNode(int row, int col, int curDist, boolean isBreakingWallPossible) {
        this.row = row;
        this.col = col;
        this.curDist = curDist;
        this.isBreakingWallPossible = isBreakingWallPossible;
    }
}

public class Main {
    private static int N, M;
    private static int[][] board;
    private static Queue<GraphNode> queue;
    private static boolean[][] visitedWhenIsBreakingWallPossible;
    private static boolean[][] visitedWhenIsNotBreakingWallPossible;
    private static int[] drow = {-1,1,0,0};
    private static int[] dcol = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = line.charAt(j) - '0';
            }
        }
        visitedWhenIsNotBreakingWallPossible = new boolean[N][M];
        visitedWhenIsBreakingWallPossible = new boolean[N][M];
        queue = new LinkedList<>();
        queue.add(new GraphNode(0,0,1,true));
        int result = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            GraphNode node = queue.poll();

            if(node.row == N - 1 && node.col == M - 1) {
                result = Math.min(result, node.curDist);
                continue;
            }
            if(node.isBreakingWallPossible) {
                if(visitedWhenIsBreakingWallPossible[node.row][node.col]) {
                    continue;
                } else {
                    visitedWhenIsBreakingWallPossible[node.row][node.col] = true;
                }
            }
            if(!node.isBreakingWallPossible){
                if(visitedWhenIsNotBreakingWallPossible[node.row][node.col]) {
                    continue;
                } else {
                    visitedWhenIsNotBreakingWallPossible[node.row][node.col] = true;
                }
            }

            for(int i=0;i<4;i++) {
                int nrow = drow[i] + node.row;
                int ncol = dcol[i] + node.col;
                if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= M) continue;
                if(node.isBreakingWallPossible) {
                    if(board[nrow][ncol] == 1) {
                        queue.add(new GraphNode(nrow, ncol, node.curDist + 1,false));
                    } else {
                        queue.add(new GraphNode(nrow, ncol, node.curDist + 1,true));
                    }
                } else {
                    if(board[nrow][ncol] == 0) {
                        queue.add(new GraphNode(nrow, ncol, node.curDist + 1,false));
                    }
                }
            }
        }
        if(result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}