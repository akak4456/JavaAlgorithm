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
	private static int N;
	private static char[][] board;
	private static boolean[][] visited;
	private static int[] drow = {-1,1,0,0};
	private static int[] dcol = {0,0,-1,1};
	private static void dfs(int row, int col, boolean isBlindness) {
		if(visited[row][col]) return;
		visited[row][col] = true;
		for(int i=0;i<4;i++) {
			int nrow = row + drow[i];
			int ncol = col + dcol[i];
			if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= N) continue;
			if(isBlindness) {
				if(board[row][col] == 'R' || board[row][col] == 'G') {
					if(board[nrow][ncol] == 'R' || board[nrow][ncol] == 'G') {
						dfs(nrow, ncol, isBlindness);
					}
				} else if(board[row][col] == 'B' && board[nrow][ncol] == 'B') {
					dfs(nrow, ncol, isBlindness);
				}
			} else {
				if(board[row][col] == board[nrow][ncol]) {
					dfs(nrow,ncol,isBlindness);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		visited = new boolean[N][N];
		int notBlindCnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if (!visited[i][j]) {
					notBlindCnt++;
					dfs(i,j,false);
				}
			}
		}
		visited = new boolean[N][N];
		int blindCnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if (!visited[i][j]) {
					blindCnt++;
					dfs(i,j,true);
				}
			}
		}
		System.out.println(notBlindCnt + " " + blindCnt);
	}
}