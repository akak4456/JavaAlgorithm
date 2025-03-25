import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static ArrayList<ArrayList<Integer>> adj;
    private static boolean[] visited;
    private static int[] parent;
    private static void dfs(int par, int node) {
        if(visited[node]) return;
        visited[node] = true;
        parent[node] = par;
        for(int i=0;i<adj.get(node).size();i++) {
            int adjNode = adj.get(node).get(i);
            if(!visited[adjNode]) {
                dfs(node, adjNode);
            }
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];
        parent = new int[N + 1];
        for(int i=0;i<N-1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        dfs(0, 1);
        for(int i=2;i<=N;i++) {
            System.out.println(parent[i]);
        }
    }

}