import java.io.*;
import java.util.*;
class P {
	int row;
	int col;
	int time;

	public P(int row, int col, int time) {
		this.row = row;
		this.col = col;
		this.time = time;
	}
}
public class Main {
	private static int N, M;
	private static int[][] board;
	private static int[] drow = {-1,1,0,0};
	private static int[] dcol = {0,0,-1,1};
	private static int[][] result;
	private static Queue<P> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		result = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 2) {
					queue.add(new P(i, j, 0));
				}
			}
		}
		while(!queue.isEmpty()) {
			P p = queue.poll();
			if(board[p.row][p.col] != 1 && board[p.row][p.col] != 2) continue;
			board[p.row][p.col] = 3;
			result[p.row][p.col] = p.time;
			for(int i = 0; i < 4; i++) {
				int nrow = p.row + drow[i];
				int ncol = p.col + dcol[i];
				if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= M) continue;
				if(board[nrow][ncol] == 1) {
					queue.add(new P(nrow, ncol, p.time + 1));
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j] == 1) {
					System.out.print("-1 ");
				} else {
					System.out.print(result[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}