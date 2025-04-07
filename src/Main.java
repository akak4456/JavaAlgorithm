import java.io.*;
import java.util.*;
class GraphPair implements Comparable<GraphPair> {
    int node;
    int dist;
    public GraphPair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    @Override
    public int compareTo(GraphPair o) {
        return Integer.compare(this.dist, o.dist);
    }
}
public class Main {
    private static final int INF = 987654321;
    private static int N;
    private static int M;
    private static int[][] adj;
    private static int[] d;
    private static PriorityQueue<GraphPair> pq;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adj = new int[N + 1][N + 1];
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(i == j) {
                    adj[i][j] = 0;
                } else {
                    adj[i][j] = INF;
                }
            }
        }
        for(int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            adj[start][end] = Math.min(dist, adj[start][end]);
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        d = new int[N + 1];
        Arrays.fill(d, INF);
        int targetStart = Integer.parseInt(st.nextToken());
        int targetEnd = Integer.parseInt(st.nextToken());
        d[targetStart] = 0;
        pq = new PriorityQueue<>();
        pq.add(new GraphPair(targetStart, 0));
        while(!pq.isEmpty()) {
            GraphPair pair = pq.poll();
            int current = pair.node;
            int distance = pair.dist;
            if(d[current] < distance) continue;
            for(int next=1;next<=N;next++) {
                if(next == current) continue;
                int nextDistance = distance + adj[current][next];
                if(nextDistance < d[next]) {
                    d[next] = nextDistance;
                    pq.add(new GraphPair(next, nextDistance));
                }
            }
        }
        System.out.println(d[targetEnd]);
    }

}