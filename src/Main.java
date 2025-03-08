import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class P {
	int row;
	int col;
	public P(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
public class Main {
	private static int N;
	private static int[][] board;
	private static Queue<P> queue;
	private static int[] dcol = {0,0,-1,1};
	private static int[] drow = {-1,1,0,0};
	private static ArrayList<Integer> result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				board[i][j] = line.charAt(j) - '0';
			}
		}
		queue = new LinkedList<>();
		result = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(board[i][j] == 1) {
					int cnt = 0;
					queue.add(new P(i,j));
					while(!queue.isEmpty()) {
						P p = queue.poll();
						if(board[p.row][p.col] != 1) continue;
						board[p.row][p.col] = 2;
						cnt++;
						for(int t=0;t<4;t++) {
							int nrow = p.row + drow[t];
							int ncol = p.col + dcol[t];
							if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= N) continue;
							if(board[nrow][ncol] != 1) continue;
							queue.add(new P(nrow, ncol));
						}
					}
					result.add(cnt);
				}
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
	}
}