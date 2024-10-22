import java.io.*;
import java.util.*;

public class Main {
	private static int N,M,B;
	private static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ansTime = 987654321;
		int ansHeight = 987654321;
		for(int targetHeight = 256; targetHeight >= 0; targetHeight--) {
			int remainCount = B;
			int neededTime = 0;
			for(int row = 0;row < N; row++) {
				for(int col = 0;col < M;col++) {
					remainCount += board[row][col] - targetHeight;
					if(targetHeight > board[row][col]) {
						neededTime += (targetHeight - board[row][col]);
					} else {
						neededTime += (board[row][col] - targetHeight) * 2;
					}
				}
			}
			if(remainCount >= 0 && neededTime < ansTime) {
				ansTime = neededTime;
				ansHeight = targetHeight;
			}
		}
		System.out.println(ansTime + " " + ansHeight);
	}
}