import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class P {
	int col;
	int row;
	public P(int row, int col) {
		this.col = col;
		this.row = row;
	}
}
public class Main {
	private static int N, M;
	private static char[][] board;
	private static int[] dcol = {0,0,-1,1};
	private static int[] drow = {-1,1,0,0};
	private static Queue<P> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++){
				board[i][j] = line.charAt(j);
				if(board[i][j] == 'I') {
					queue.add(new P(i, j));
				}
			}
		}
		int cnt = 0;
		while(!queue.isEmpty()) {
			P p = queue.poll();
			if(board[p.row][p.col] == 'V') continue;
			if(board[p.row][p.col] == 'P') {
				cnt++;
			}
			board[p.row][p.col] = 'V';
			for(int i=0;i<4;i++) {
				int nrow = p.row + drow[i];
				int ncol = p.col + dcol[i];
				if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= M) continue;
				if(board[nrow][ncol] == 'P' || board[nrow][ncol] == 'O') {
					queue.add(new P(nrow, ncol));
				}
			}
		}
		if(cnt == 0) {
			System.out.println("TT");
		} else {
			System.out.println(cnt);
		}
	}
}