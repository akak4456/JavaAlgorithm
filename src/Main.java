import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int[][] dist;
    private static int[][] next;
    private static final int INF = 987654321;
    private static ArrayList<Integer> path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n + 1][n + 1];
        next = new int[n + 1][n + 1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }
        for(int i=1;i<=m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c);
            next[a][b] = b;
        }
        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(dist[start][end]);
        path = new ArrayList<>();
        path.add(start);
        int nxt = start;
        while(nxt != end) {
            nxt = next[nxt][end];
            path.add(nxt);
        }
        System.out.println(path.size());
        for(int i=0;i<path.size();i++) {
            System.out.print(path.get(i) + " ");
        }
    }
}