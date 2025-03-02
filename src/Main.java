import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
	private static int N;
	private static int board[][];
	private static int whiteCnt;
	private static int blueCnt;
	private static void solve(int startRow, int endRow, int startCol, int endCol) {
		boolean isWhite = true;
		for(int i=startRow; i<=endRow;i++) {
			for(int j=startCol;j<=endCol;j++) {
				if(board[i][j] != 0) {
					isWhite = false;
				}
			}
		}
		if(isWhite) {
			whiteCnt++;
			return;
		}
		boolean isBlue = true;
		for(int i=startRow; i<=endRow;i++) {
			for(int j=startCol;j<=endCol;j++) {
				if(board[i][j] != 1) {
					isBlue = false;
				}
			}
		}
		if(isBlue) {
			blueCnt++;
			return;
		}
		int midRow = (startRow+endRow)/2;
		int midCol = (startCol+endCol)/2;
		solve(startRow, midRow, startCol, midCol);
		solve(midRow + 1,endRow, startCol, midCol);
		solve(startRow,midRow, midCol + 1, endCol);
		solve(midRow+1, endRow, midCol + 1, endCol);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(0, N-1, 0, N-1);
		System.out.println(whiteCnt);
		System.out.println(blueCnt);
	}
}