import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
	private static int N, M, B;
	private static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int minTime = Integer.MAX_VALUE;
		int minHeight = 0;
		for(int targetHeight = 0; targetHeight <= 256; targetHeight++) {
			int addBlock = 0;
			int subtractBlock = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(board[i][j] < targetHeight) {
						addBlock += targetHeight - board[i][j];
					} else if(board[i][j] > targetHeight) {
						subtractBlock += board[i][j] - targetHeight;
					}
				}
			}
			if(B + subtractBlock - addBlock < 0) continue;
			int time = addBlock + subtractBlock * 2;
			if(time <= minTime) {
				minTime = time;
				minHeight = targetHeight;
			}
		}
		System.out.println(minTime + " " + minHeight);
	}
}