import java.io.*;
import java.util.*;

public class Main {
	private static int T;
	private static int k,n;
	private static int board[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[14 + 1][14 + 1];
		T = Integer.parseInt(br.readLine());
		for(int i=1;i<=14;i++) {
			board[0][i] = i;
		}
		for(int i=1;i<=14;i++) {
			for(int j=1;j<=14;j++) {
				int sum = 0;
				for(int k=1;k<=j;k++) {
					sum += board[i-1][k];
				}
				board[i][j] = sum;
			}
		}
		for (int i = 0; i < T; i++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			System.out.println(board[k][n]);
		}
	}
}