import java.io.*;
import java.util.*;
public class Main {
    private static int N, E;
    private static int[][] dist;
    private static final int INF = 400000000;
    private static int v1,v2;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new int[N + 1][N + 1];
        for(int i=0;i<=N;i++) {
            for(int j=0;j<=N;j++) {
                if(i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }
        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
            dist[b][a] = c;
        }
        for(int k=1;k<=N;k++) {
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        int d1 = dist[1][v1] + dist[v1][v2] + dist[v2][N];
        int d2 = dist[1][v2] + dist[v2][v1] + dist[v1][N];
        if(d1 >= INF && d2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(d1, d2));
        }
    }

}