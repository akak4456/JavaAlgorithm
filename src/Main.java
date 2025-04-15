import java.io.*;
import java.util.*;
class AdjGraphNode {
    int adj;
    int cost;

    public AdjGraphNode(int adj, int cost) {
        this.adj = adj;
        this.cost = cost;
    }
}
class PQNode implements Comparable<PQNode> {
    int node;
    int dist;
    public PQNode(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    @Override
    public int compareTo(PQNode o) {
        return Integer.compare(this.dist, o.dist);
    }
}
public class Main {
    private static int V, E;
    private static int K;
    private static final int INF = 987654321;
    private static ArrayList<ArrayList<AdjGraphNode>> adj;
    private static int dist[];
    private static PriorityQueue<PQNode> pq;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        for(int i=0;i<=V;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(u).add(new AdjGraphNode(v, w));
        }
        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[K] = 0;
        pq = new PriorityQueue<>();
        pq.add(new PQNode(K, 0));
        while(!pq.isEmpty()) {
            PQNode cur = pq.poll();
            if(dist[cur.node] < cur.dist) continue;
            for(int i=0;i<adj.get(cur.node).size();i++) {
                AdjGraphNode adjNode = adj.get(cur.node).get(i);
                int newCost = cur.dist + adjNode.cost;
                if(newCost < dist[adjNode.adj]) {
                    dist[adjNode.adj] = newCost;
                    pq.add(new PQNode(adjNode.adj, newCost));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=V;i++) {
            if(dist[i] != INF) {
                sb.append(dist[i]).append("\n");
            } else {
                sb.append("INF\n");
            }
        }
        System.out.println(sb);
    }

}