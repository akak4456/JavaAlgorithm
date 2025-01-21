import java.io.*;
import java.util.*;

public class Main {
	private static int N, M;
	private static  char board[][];
	private static int needCnt(char startChar, int startRow, int startCol) {
		int ret = 0;
		for(int drow = 0; drow < 8; drow++) {
			for(int dcol = 0; dcol < 8; dcol++) {
				if(drow % 2 == 0) {
					if(dcol % 2 == 0 && board[startRow+drow][startCol+dcol] == startChar) {
						ret++;
					}
					if(dcol % 2 != 0 && board[startRow+drow][startCol+dcol] != startChar) {
						ret++;
					}
				} else {
					if(dcol % 2 == 0 && board[startRow+drow][startCol+dcol] != startChar) {
						ret++;
					}
					if(dcol % 2 != 0 && board[startRow+drow][startCol+dcol] == startChar) {
						ret++;
					}
				}
			}
		}
		return ret;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				board[i][j] = line.charAt(j);
			}
		}

		int minValue = Integer.MAX_VALUE;
		for(int row=0;row+8 <= N;row++) {
			for(int col=0;col+8 <= M;col++) {
				minValue = Math.min(minValue, needCnt('W',row,col));
				minValue = Math.min(minValue, needCnt('B',row,col));
			}
		}
		System.out.println(minValue);
	}
}