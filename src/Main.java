import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    private static int TC;
    private static int N, M, W;
    private static int dist[][];
    private static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        for(int testCase = 0; testCase < TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            dist = new int[N + 1][N + 1];
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    if(i == j) {
                        dist[i][j] = 0;
                    } else {
                        dist[i][j] = INF;
                    }
                }
            }
            for(int i=1;i<=M;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                dist[a][b] = Math.min(dist[a][b], t);
                dist[b][a] = Math.min(dist[b][a], t);
            }
            for(int i=1;i<=W;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                dist[a][b] = -t;
            }
            for(int k=1;k<=N;k++) {
                for(int i=1;i<=N;i++) {
                    for(int j=1;j<=N;j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
            boolean isPossible = false;
            for(int i=1;i<=N;i++) {
                if(dist[i][i] < 0) {
                    isPossible = true;
                    break;
                }
            }
            if(isPossible) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}