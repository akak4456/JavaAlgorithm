import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class GraphPair implements Comparable<GraphPair> {
    int first;
    int second;

    GraphPair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(GraphPair o) {
        if(o.first == this.first) {
            return o.second - this.second;
        } else {
            return o.first - this.first;
        }
    }

}
public class Main {
    private static int N;
    private static int K;
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    private static final int INF = 987654321;
    private static int d[] = new int[100000 + 1];
    private static PriorityQueue<GraphPair> pq = new PriorityQueue<GraphPair>();
    private static int dp[] = new int[100000 + 1];
    private static int dfs(int node) {
        if(node == K) {
            return 1;
        }
        int ret = dp[node];
        if(ret != -1) return ret;
        ret = 0;
        for(int i=0;i<adj.get(node).size();i++) {
            int adjNode = adj.get(node).get(i);
            if(d[node] + 1 == d[adjNode]) {
                ret += dfs(adjNode);
            }
        }
        dp[node] = ret;
        return ret;
    }
    public static void main(String[] args) throws IOException {
        // 입력 최적화를 위해서 Scanner 대신에 BufferedReader, StringTokenizer 를
        // 혼합하는 방식으로 사용함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i=0;i<=100000;i++) {
            ArrayList<Integer> child = new ArrayList<Integer>();
            if(i - 1 >= 0) {
                child.add(i-1);
            }
            if(i + 1 <= 100000) {
                child.add(i + 1);
            }
            if(i*2 <= 100000) {
                child.add(i * 2);
            }
            adj.add(child);
        }
        Arrays.fill(d, INF);
        d[N] = 0;
        pq.add(new GraphPair(-0, N));
        while(!pq.isEmpty()) {
            int cost = -pq.peek().first;
            int node = pq.peek().second;
            pq.poll();
            if(cost > d[node]) continue;
            for(int i=0;i<adj.get(node).size();i++) {
                int newNode = adj.get(node).get(i);
                int newCost = cost + 1;
                if(newCost < d[newNode]) {
                    d[newNode] = newCost;
                    pq.add(new GraphPair(-newCost, newNode));
                }
            }
        }
        Arrays.fill(dp, -1);
        System.out.println(d[K]);
        System.out.println(dfs(N));
    }
}