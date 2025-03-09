import java.io.*;
import java.util.*;
class P implements Comparable<P> {
	int value;
	int absValue;

	public P(int value) {
		this.value = value;
		this.absValue = Math.abs(value);
	}
	@Override
	public int compareTo(P o) {
		if(this.absValue == o.absValue) {
			return Integer.compare(this.value, o.value);
		}
		return Integer.compare(this.absValue, o.absValue);
	}
}
public class Main {
	private static int N;
	private static final int INF = 987654321;
	private static int[][] dist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dist = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a == 0) {
					if(i == j) {
						dist[i][j] = 0;
					} else {
						dist[i][j] = INF;
					}
				} else {
					dist[i][j] = 1;
				}
			}
		}
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i == j) {
					boolean isPossible = false;
					for(int k=0;k<N;k++) {
						if(i == k) continue;
						if(dist[i][k] != INF && dist[k][i] != INF) {
							isPossible = true;
							break;
						}
					}
					if(isPossible) {
						System.out.print("1 ");
					} else {
						System.out.print("0 ");
					}
				} else {
					if(dist[i][j] == INF) {
						System.out.print("0 ");
					} else {
						System.out.print("1 ");
					}
				}
			}
			System.out.println();
		}
	}
}