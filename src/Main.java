import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class P{
	int row;
	int col;
	public P(int row, int col){
		this.row = row;
		this.col = col;
	}
}
public class Main {
	private static int T;
	private static int M, N, K;
	private static int board[][];
	private static Queue<P> queue;
	private static int[] dcol = {0,0,-1,1};
	private static int[] drow = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int testCase = 0; testCase < T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new int[N][M];
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				board[y][x] = 1;
			}
			queue = new LinkedList<>();
			int cnt = 0;
			for(int row=0;row<N;row++) {
				for(int col=0;col<M;col++) {
					if(board[row][col] == 1) {
						cnt++;
						queue.add(new P(row, col));
						while(!queue.isEmpty()) {
							P p = queue.poll();
							if(board[p.row][p.col] == 1) {
								board[p.row][p.col] = 0;
								for (int i = 0; i < 4; i++) {
									int nrow = p.row + drow[i];
									int ncol = p.col + dcol[i];
									if (nrow < 0 || nrow >= N || ncol < 0 || ncol >= M || board[nrow][ncol] != 1)
										continue;
									queue.add(new P(nrow, ncol));
								}
							}
						}
					}
				}
			}
			System.out.println(cnt);
		}

	}
}