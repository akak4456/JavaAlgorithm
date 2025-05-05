import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class GraphNode implements Comparable<GraphNode> {
    int row;
    int col;
    int dist;
    public GraphNode(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }

    @Override
    public int compareTo(GraphNode o) {
        if(this.dist == o.dist) {
            if(this.row == o.row) {
                return Integer.compare(this.col, o.col);
            }
            return Integer.compare(this.row, o.row);
        }
        return Integer.compare(this.dist, o.dist);
    }
}
public class Main {
    private static int N;
    private static int[][] board;
    private static int[] drow = {-1,1,0,0};
    private static int[] dcol = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        int sharkRow = 0;
        int sharkCol = 0;
        int sharkSize = 2;
        int sharkEat = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 9) {
                    sharkRow = i;
                    sharkCol = j;
                }
            }
        }
        int time = 0;
        while(true) {
            boolean[][] visited = new boolean[N][N];
            Queue<GraphNode> queue = new LinkedList<>();
            GraphNode fishTarget = null;
            queue.add(new GraphNode(sharkRow, sharkCol, 0));
            while(!queue.isEmpty()) {
                GraphNode node = queue.poll();
                if(visited[node.row][node.col]) continue;
                visited[node.row][node.col] = true;
                if(!(node.row == sharkRow && node.col == sharkCol) && board[node.row][node.col] > 0 && board[node.row][node.col] < sharkSize) {
                    if(fishTarget == null || fishTarget.compareTo(node) > 0) {
                        fishTarget = node;
                    }
                }
                for(int i=0;i<4;i++) {
                    int nrow = node.row + drow[i];
                    int ncol = node.col + dcol[i];
                    if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= N) continue;
                    if(!visited[nrow][ncol] && board[nrow][ncol] <= sharkSize) {
                        queue.add(new GraphNode(nrow, ncol, node.dist + 1));
                    }
                }
            }
            if(fishTarget == null) break;
            board[sharkRow][sharkCol] = 0;
            sharkRow = fishTarget.row;
            sharkCol = fishTarget.col;
            sharkEat++;
            if(sharkEat == sharkSize) {
                sharkEat = 0;
                sharkSize++;
            }
            time+=fishTarget.dist;
            board[sharkRow][sharkCol] = 9;
        }
        System.out.println(time);
    }
}