import java.io.*;
import java.util.*;
class PQNode implements Comparable<PQNode> {
    int current;
    int dist;

    public PQNode(int current, int dist) {
        this.current = current;
        this.dist = dist;
    }

    @Override
    public int compareTo(PQNode o) {
        return Integer.compare(dist, o.dist);
    }
}
public class Main {
    private static final int INF = 987654321;
    private static int N, K;
    private static int[] d;
    private static PriorityQueue<PQNode> pq;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        d = new int[100000 + 1];
        Arrays.fill(d, INF);
        d[N] = 0;
        pq.add(new PQNode(N, 0));
        while(!pq.isEmpty()) {
            PQNode cur = pq.poll();
            int current = cur.current;
            int dist = cur.dist;
            if(d[current] < dist) continue;
            if(current - 1 >= 0 && d[current - 1] > dist + 1) {
                d[current - 1] = dist + 1;
                pq.add(new PQNode(current - 1, dist + 1));
            }
            if(current + 1 <= 100000 && d[current + 1] > dist + 1) {
                d[current + 1] = dist + 1;
                pq.add(new PQNode(current + 1, dist + 1));
            }
            if(current * 2 <= 100000 && d[current * 2] > dist) {
                d[current * 2] = dist;
                pq.add(new PQNode(current * 2, dist));
            }
        }
        System.out.println(d[K]);
    }

}