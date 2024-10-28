import java.io.*;
import java.util.*;
class Node {
	int row;
	int col;
	int curDay;

	Node(int row, int col) {
		this.row = row;
		this.col = col;
		this.curDay = 0;
	}

	Node(int row, int col, int curDay) {
		this.row = row;
		this.col = col;
		this.curDay = curDay;
	}
}
public class Main {
	private static int M, N;
	private static int[][] board;
	private static Queue<Node> q = new LinkedList<>();
	private static final int[] drow = {-1,1,0,0};
	private static final int[] dcol = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) {
					q.add(new Node(i,j));
				}
			}
		}
		int ans = 0;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(board[cur.row][cur.col] == 2) continue;
			board[cur.row][cur.col] = 2;
			ans = Math.max(ans, cur.curDay);
			for(int i=0;i<4;i++) {
				int nrow = cur.row + drow[i];
				int ncol = cur.col + dcol[i];
				if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= M || board[nrow][ncol] == -1 || board[nrow][ncol] == 1 || board[nrow][ncol] == 2) continue;
				q.add(new Node(nrow, ncol, cur.curDay + 1));
			}
		}
		boolean isPossible = true;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(board[i][j] == 0) {
					isPossible = false;
				}
			}
		}
		if(isPossible) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}
	}
}