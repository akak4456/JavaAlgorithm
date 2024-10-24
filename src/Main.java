import java.io.*;
import java.util.*;
class Node {
	int row;
	int col;

	Node(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
public class Main {
	private static int N, M;
	private static Node[] nodes;
	private static int[] ans;
	private static char[][] board;
	private static Queue<Node> q;
	private static final int[] dcol = {0,0,-1,1};
	private static final int[] drow = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<M;j++) {
				board[i][j] = tmp.charAt(j);
				if(board[i][j] == 'I') {
					q.add(new Node(i, j));
				}
			}
		}

		int cnt = 0;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(board[cur.row][cur.col] == 'V') {
				continue;
			}
			if(board[cur.row][cur.col] == 'P') {
				cnt++;
			}
			board[cur.row][cur.col] = 'V';
			for(int i=0;i<4;i++) {
				int nrow = cur.row + drow[i];
				int ncol = cur.col + dcol[i];
				if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= M || board[nrow][ncol] == 'X' || board[nrow][ncol] == 'V' ) {
					continue;
				}
				q.add(new Node(nrow, ncol));
			}
		}
		if(cnt == 0) {
			System.out.println("TT");
		} else {
			System.out.println(cnt);
		}
	}
}