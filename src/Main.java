import java.io.*;
import java.util.*;
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

class DFS {
	private ArrayList<ArrayList<Integer>> graph;
	private int[] discovered;
	private boolean[] finished;
	private int nodeOrder;
	private int cycle;
	
	public DFS(ArrayList<ArrayList<Integer>> graph, int startNodeIdx, int nodeCount) {
		this.graph = graph;
		this.discovered = new int[nodeCount];
		Arrays.fill(this.discovered, -1);
		this.finished = new boolean[nodeCount];
		this.nodeOrder = 0;
		this.cycle = 0;
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
	private static int arr[];
	private static int dp[][];
	private static int solve(int step, int cnt) {
		if(step == N) {
			// 마지막 계단은 무조건 밟아야 하므로
			return 0;
		}
		if(dp[step][cnt] != -1) {
			return dp[step][cnt];
		}
		dp[step][cnt] = -987654321;
		if(step + 2 <= N) {
			dp[step][cnt] = Math.max(dp[step][cnt], solve(step + 2, 1) + arr[step + 2]);
		}
		if(step + 1 <= N && cnt < 2) {
			dp[step][cnt] = Math.max(dp[step][cnt], solve(step + 1, cnt + 1) + arr[step + 1]);
		}
		// System.out.println(step + " " + cnt + " " + dp[step][cnt]);
		return dp[step][cnt];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp = new int[N + 1][3];
		for(int i=0;i<=N;i++) {
			for(int j=0;j<3;j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(solve(0, 0));
	}  
}