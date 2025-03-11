import java.io.*;
import java.util.*;
class P{
	int row;
	int col;
	int h;
	int time;
	public P(int row, int col, int h, int time) {
		this.row = row;
		this.col = col;
		this.h = h;
		this.time = time;
	}
}
public class Main {
	private static int M, N, H;
	private static int[][][] board;
	private static Queue<P> queue;
	private static int[] drow = {-1,1,0,0};
	private static int[] dcol = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = 1;
		board = new int[N][M][H];
		queue = new LinkedList<>();
		for(int h = 0; h < H; h++) {
			for(int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int col = 0; col < M; col++) {
					board[row][col][h] = Integer.parseInt(st.nextToken());
					if(board[row][col][h] == 1) {
						queue.add(new P(row, col, h, 0));
					}
				}
			}
		}
		int curTime = 0;
		while(!queue.isEmpty()) {
			P p = queue.poll();
			if(board[p.row][p.col][p.h] == 2) continue;
			board[p.row][p.col][p.h] = 2;
			curTime = Math.max(curTime, p.time);
			for(int i=0;i<4;i++) {
				int nrow = p.row + drow[i];
				int ncol = p.col + dcol[i];
				if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= M || board[nrow][ncol][p.h] != 0) continue;
				queue.add(new P(nrow, ncol, p.h, p.time + 1));
			}
		}
		boolean isPossible = true;
		for(int h = 0; h < H; h++) {
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < M; col++) {
					if(board[row][col][h] == 0) {
						isPossible = false;
					}
				}
			}
		}
		if(isPossible) {
			System.out.println(curTime);
		} else {
			System.out.println(-1);
		}
	}
}