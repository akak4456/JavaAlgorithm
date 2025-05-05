import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class AdjNode {
    int adjNode;
    int dist;
    public AdjNode(int adjNode, int dist) {
        this.adjNode = adjNode;
        this.dist = dist;
    }
}
public class Main {
    private static int V;
    private static ArrayList<ArrayList<AdjNode>> adj;
    private static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            while(true) {
                int adjNode = Integer.parseInt(st.nextToken());
                if(adjNode == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                adj.get(v).add(new AdjNode(adjNode, dist));
            }
        }
        dfs(1, -1);
        System.out.println(result);
    }
    private static int dfs(int curr, int parent) {
        int max1 = 0, max2 = 0;

        for (AdjNode edge : adj.get(curr)) {
            if (edge.adjNode == parent) continue; // 부모로는 되돌아가지 않음

            int childCost = dfs(edge.adjNode, curr) + edge.dist;

            // 상위 두 개 경로만 유지 (지름 계산 위해)
            if (childCost > max1) {
                max2 = max1;
                max1 = childCost;
            } else if (childCost > max2) {
                max2 = childCost;
            }
        }

        result = Math.max(result, max1 + max2); // 트리의 지름 갱신
        return max1;
    }
}