import java.io.*;
import java.util.*;
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
	private static int N, r, c;
	private static int solve(int startRow, int startCol, int endRow, int endCol) {
		if(endRow - startRow == 1 && endCol - startCol == 1) {
			int rowDist = r - startRow;
			int colDist = c - startCol;
			if(rowDist == 0) {
				if(colDist == 0) {
					return 0;
				} else {
					return 1;
				}
			} else {
				if(colDist == 0) {
					return 2;
				} else {
					return 3;
				}
			}
		}
		int midRow = (startRow + endRow) / 2;
		int midCol = (startCol + endCol) / 2;
		int cnt = ((endRow - startRow + 1) / 2) * ((endCol - startCol + 1) / 2);
		if(startRow <= r && r <= midRow && startCol <= c && c <= midCol) {
			return solve(startRow, startCol, midRow, midCol);
		} else if(startRow <= r && r <= midRow && midCol + 1 <= c && c <= endCol) {
			return solve(startRow, midCol + 1, midRow, endCol) + cnt;
		} else if(midRow + 1 <= r && r <= endRow && startCol <= c && c <= midCol) {
			return solve(midRow + 1, startCol, endRow, midCol) + cnt * 2;
		} else {
			return solve(midRow + 1, midCol + 1, endRow, endCol) + cnt * 3;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int endVal = (int)Math.pow(2, N);
		System.out.println(solve(0,0,endVal-1, endVal-1));
	}
}