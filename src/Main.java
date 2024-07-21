import java.io.*;
import java.util.*;

class UnionFind {
	private int[] parent;

	public UnionFind(int nodeSize) {
		parent = new int[nodeSize];
		for(int i=0;i<nodeSize;i++) {
			parent[i] = i;
		}
	}

	public void union(int x, int y) {
		x = find(x);
		y = find(y);
		// 가르키는 부모노드가 다를때
		if(x > y) {
			parent[y] = x;
		} else if(x < y) {
			parent[x] = y;
		}
	}

	public int find(int x) {
		if(parent[x] == x)
			return x;
		else
			// 재귀를 통해 부모노드를 계속해서 찾아감
			return parent[x] = find(parent[x]);
	}

	//같은 부모 노드인지
	public boolean isSame(int x, int y) {
		if(find(x) == find(y))
			return true;
		else
			return false;
	}

}

public class Main {
	private static int N, M, K;
	private static int[] arr;
	private static int[] group;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[M];
		group = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<M;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr);
		int curIdx = 0;
		for(int i=0;i<=N;i++) {
			if(curIdx < M && arr[curIdx] == i) {
				curIdx++;
			}
			group[i] = curIdx;
		}
		UnionFind uf = new UnionFind(M + 1);
		for(int i=0;i<K;i++) {
			int target = Integer.parseInt(st.nextToken());
			int parent = uf.find(group[target]);
			int ans = arr[parent];
			uf.union(parent, parent + 1);
			sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}