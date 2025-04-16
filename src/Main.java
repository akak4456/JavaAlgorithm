import java.io.*;
import java.util.*;
class Edge {
    int to, cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main {
    static List<Edge>[] tree;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tree[a].add(new Edge(b, c));
            tree[b].add(new Edge(a, c));
        }

        dfs(1, -1);
        System.out.println(result);
    }

    // dfs 함수는 현재 노드에서 자식 방향으로 가장 긴 경로의 길이를 반환
    private static int dfs(int curr, int parent) {
        int max1 = 0, max2 = 0;

        for (Edge edge : tree[curr]) {
            if (edge.to == parent) continue; // 부모로는 되돌아가지 않음

            int childCost = dfs(edge.to, curr) + edge.cost;

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