import java.io.*;
import java.util.*;
class Node {
	int row;
	int col;
	int curDist;

	Node(int row, int col) {
		this.row = row;
		this.col = col;
		this.curDist = 0;
	}

	Node(int row, int col, int curDist) {
		this.row = row;
		this.col = col;
		this.curDist = curDist;
	}
}
public class Main {
	private static int n, m;
	private static final int[] dcol = {0,0,-1,1};
	private static final int[] drow = {-1,1,0,0};
	private static int[][] board;
	private static Queue<Node> q;
	private static int[][] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		ans = new int[n][m];
		q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 2) {
					q.add(new Node(i, j));
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(board[i][j] > 0) {
					ans[i][j] = -1;
				}
			}
		}
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(board[cur.row][cur.col] == 0) continue;
			board[cur.row][cur.col] = 0;
			ans[cur.row][cur.col] = cur.curDist;
			for(int i=0;i<4;i++) {
				int nrow = cur.row + drow[i];
				int ncol = cur.col + dcol[i];
				if(nrow < 0 || nrow >= n || ncol < 0 || ncol >= m || board[nrow][ncol] == 0) continue;
				q.add(new Node(nrow, ncol, cur.curDist + 1));
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				sb.append(ans[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}