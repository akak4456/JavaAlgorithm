import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
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
	private static Queue<P> queue;
	private static int[] dcol = {0,0,-1,1};
	private static int[] drow = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j) - '0';
			}
		}
		queue = new LinkedList<>();
		queue.add(new P(0,0,1));
		int minTime = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			P p = queue.poll();
			if(board[p.row][p.col] != 1) continue;
			if(p.row == N-1 && p.col == M-1) {
				minTime = Math.min(minTime, p.time);
			}
			board[p.row][p.col] = 2;
			for(int i=0;i<4;i++) {
				int nrow = p.row + drow[i];
				int ncol = p.col + dcol[i];
				if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= M) continue;
				if(board[nrow][ncol] != 1) continue;
				queue.add(new P(nrow, ncol, p.time+1));
			}
		}
		System.out.println(minTime);
	}
}