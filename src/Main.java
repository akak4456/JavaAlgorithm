import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class TreeNode {
	int adjNode;
	int dist;
	TreeNode(int adjNode, int dist) {
		this.adjNode = adjNode;
		this.dist = dist;
	}
}
public class Main {
	private static int N;
	private static ArrayList<ArrayList<TreeNode>> adj;
	private static int[][] parent;
	private static int[] level;
	private static final int maxLevel = 20;
	private static int[] distFromRoot;
	private static int M;
	private static void setTree(int node, int pnode, int lv, int dFromRoot) {
		level[node] = lv;
		parent[node][0] = pnode;
		distFromRoot[node] = dFromRoot;

		for(int i=1;i<=maxLevel;i++) {
			parent[node][i] = parent[parent[node][i-1]][i-1];
		}
		for(int i=0;i<adj.get(node).size();i++) {
			TreeNode childNode = adj.get(node).get(i);
			if(childNode.adjNode == pnode) continue;
			setTree(childNode.adjNode, node, lv+1, dFromRoot + childNode.dist);
		}
	}
	private static int LCA(int a, int b) {
		if(a == 1 || b == 1) return 1;
		int target = a;
		int compare = b;
		if(level[a] < level[b]) {
			int tmp = target;
			target = compare;
			compare = tmp;
		}
		if(level[target] != level[compare]) {
			for(int i=maxLevel; i>=0;i--) {
				if(level[parent[target][i]] >= level[compare]) {
					target = parent[target][i];
				}
			}
		}
		int ret = target;
		if(target != compare) {
			for(int i=maxLevel; i>=0;i--) {
				if(parent[target][i] != parent[compare][i]) {
					target = parent[target][i];
					compare = parent[compare][i];
				}
				ret = parent[target][i];
			}
		}
		return ret;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adj = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<N - 1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj.get(a).add(new TreeNode(b,c));
			adj.get(b).add(new TreeNode(a,c));
		}
		parent = new int[N + 1][maxLevel + 1];
		level = new int[N + 1];
		distFromRoot = new int[N + 1];
		setTree(1, 0, 1, 0);
		M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testCase=0;testCase<M;testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int lca = LCA(a, b);
			sb.append((distFromRoot[a] + distFromRoot[b] - (distFromRoot[lca] * 2)));
			sb.append('\n');
		}
		System.out.println(sb);
	}
}