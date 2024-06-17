import java.io.*;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;

/*
 * 백준 등 알고리즘 문제를 푸는데 도움이 되는 라이브러리
 * 다익스트라 알고리즘 등 기존에 잘 알려진 알고리즘 구현을 담는다.
 */
class JoLibrary{
	/*
	 * 에라토스테네스의 체를 얻는 것
	 * 0 ~ N 까지의 수 중에 소수인 수가 boolean 배열 형태로
	 * return 된다
	 * 예를 들어 boolean[2] == true, boolean[4] == false
	 * boolean[5] == true 이다.
	 */
	public static boolean[] sieveOfEratosthenes(int N) {
		boolean[] ret = new boolean[N + 1];
		Arrays.fill(ret, true);
		ret[0] = false;
		ret[1] = false;
		for(int i=2;i<=N;i++) {
			if(ret[i]) {
				for(int j=i*2;j<=N;j+=i) {
					ret[j] = false;
				}
			}
		}
		return ret;
	}
	
	/*
	 * 유클리드 호제법을 이용해서 최대 공약수를 구함
	 */
	public static long GCD(long A, long B) {
		if(A < B) {
			long tmp = A;
			A = B;
			B = tmp;
		}
		if(B == 0) {
			return A;
		}
		return GCD(B, A%B);
	}
	
	/*
	 * 최소공배수구하기
	 */
	public static long LCM(long A, long B) {
		long gcd = GCD(A, B);
		long a = A / gcd;
		long b= B / gcd;
		return gcd * a * b;
	}
	
	/*
	 * 이항계수 구하기
	 * DP 테이블을 생성해서 구현함
	 */
	public static long binomialCoefficient(int n, int k) {
        if (k > n) return 0;
        if (k == 0 || k == n) return 1;

        // DP 테이블 생성
        long[][] C = new long[n + 1][k + 1];

        // 모든 C[i][0] 및 C[i][i] 설정
        for (int i = 0; i <= n; i++) {
            C[i][0] = 1;
            if (i <= k) {
                C[i][i] = 1;
            }
        }

        // DP 테이블 채우기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }

        return C[n][k];
    }
	
}

// 인접리스트 방식의 그래프
class AdjacencyList {
	private ArrayList<ArrayList<Integer>> graph;
	private int[] discovered;
	private boolean[] finished;
	private int nodeOrder;
	private int cycle;
	
	public AdjacencyList(ArrayList<ArrayList<Integer>> graph, int startNodeIdx, int nodeSize) {
		this.graph = graph;
		this.discovered = new int[nodeSize];
		Arrays.fill(this.discovered, -1);
		this.finished = new boolean[nodeSize];
		this.nodeOrder = 0;
		this.cycle = 0;
	}
	
	public void dfs(int node, IntConsumer nodeConsumer) {
		dfs(node, nodeConsumer, (tmp) -> {});
	}
	
	public void dfs(int node, IntConsumer nodeConsumer, IntConsumer crossEdgeConsumer) {
		discovered[node] = nodeOrder++;
		nodeConsumer.accept(node);
		for(int i : graph.get(node)) {
			if(discovered[i] == -1) {
				// Tree Edge 인 경우
				dfs(i, nodeConsumer, crossEdgeConsumer);
			} else if(discovered[node] < discovered[i]) { 
				// Forward Edge 인 경우
			} else if(!finished[i]) {
				// Back Edge 인 경우
				++cycle;
			} else {
				// Cross Edge 인 경우
				crossEdgeConsumer.accept(node);
			}
		}
		
		finished[node] = true;
	}
}
// 인접 행렬 방식의 그래프
class AdjacencyMatrix {

	private int[][] board;
	private int[][] discovered;
	private boolean[][] finished;
	private int[] drow = {-1,1,0,0};
	private int[] dcol = {0,0,-1,1};
	private int nodeOrder;
	private int cycle;
	
	
	
	public AdjacencyMatrix(int[][] board) {
		this.board = board;
		this.discovered = new int[board.length][board[0].length];
		for(int i=0;i<discovered.length;i++) {
			Arrays.fill(discovered[i], -1);
		}
		this.finished = new boolean[board.length][board[0].length];
		this.nodeOrder = 0;
		this.cycle = 0;
	}
	
	public void dfs(int row, int col, BiConsumer<Integer, Integer> nodeConsumer) {
		discovered[row][col] = nodeOrder++;
		nodeConsumer.accept(row, col);
		for(int i=0;i<4;i++) {
			int nrow = row + drow[i];
			int ncol = col + dcol[i];
			if(nrow < 0 || nrow >= board.length || ncol < 0 || ncol >= board[0].length || board[nrow][ncol] == 0) continue;
			if(discovered[nrow][ncol] == -1) {
				// Tree Edge 인 경우
				dfs(nrow, ncol, nodeConsumer);
			} else if(discovered[row][col] < discovered[nrow][ncol]) { 
				// Forward Edge 인 경우
			} else if(!finished[nrow][ncol]) {
				// Back Edge 인 경우
				++cycle;
			} else {
				// Cross Edge 인 경우
			}
		}
		finished[row][col] = true;
	}
}

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
        if(x != y) {
            parent[y] = x;
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

class IntPair implements Comparable<IntPair> {
	private int first;
	private int second;
	
	public IntPair(int first, int second) {
		this.first = first;
		this.second = second;
	}
	
	public int getFirst() {
		return first;
	}
	
	public int getSecond() {
		return second;
	}

	@Override
	public int compareTo(IntPair o) {
		if(Integer.compare(this.second, o.second) == 0) {
			return Integer.compare(this.first, o.first);
		}
		return Integer.compare(this.second, o.second);
	}
	
}

class IntTriple {
	private int first;
	private int second;
	private int third;
	
	public IntTriple(int first, int second, int third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
	
	public int getFirst() {
		return first;
	}
	
	public int getSecond() {
		return second;
	}
	
	public int getThird() {
		return third;
	}
}
public class Main {
	private static int N;
	private static int[] drow = {-1,1,0,0};
	private static int[] dcol = {0,0,-1,1};
	private static int[][] graph;
	private static int curNumber = 2;
	private static int[] cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		AdjacencyMatrix matrix = new AdjacencyMatrix(graph);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(graph[i][j] == 1) {
					matrix.dfs(i, j, (row, col) -> {
						graph[row][col] = curNumber;
					});
					curNumber++;
				}
			}
		}
		cnt = new int[N*N + N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(graph[i][j] > 0) {
					cnt[graph[i][j]]++;
				}
			}
		}
		Arrays.sort(cnt);
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=2;i<cnt.length;i++) {
			if(cnt[i] > 0) {
				result.add(cnt[i]);
			}
		}
		System.out.println(result.size());
		for(int r : result) {
			System.out.println(r);
		}
	}  
}