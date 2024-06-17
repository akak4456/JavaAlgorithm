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
	private static long A, B;
	private static long[] dp;
	private static long getPartialSumInner(long remain) {
		// System.out.println("getPartialSumInner " + remain);
		long remainNum = remain;
		long ret = 0;
		int step = 0;
		while(remainNum > 0) {
			int p = 0;
			long pNum = 1;
			while(pNum * 2 < remainNum) {
				p++;
				pNum *= 2;
			}
			ret += dp[p + 1] + pNum * step;
			step++;
			remainNum -= pNum;
			// System.out.println(p + " " + ret);
		}
		return ret;
	}
	private static long getPartialSum(long num, int pow) {
		// 2^pow 부터 num 까지 1의 개수의 합을 구한다.
		long p = (long)Math.pow(2, pow - 1);
		long remainNum = num - p + 1; 
		// System.out.println("num is " + num + " remainNum is " + remainNum + " p/2 is " + p/2);
		long leftPart = getPartialSumInner(Math.min(remainNum,p/2));
		long rightPart = 0;
		if(remainNum - p/2 > 0) {
			rightPart = getPartialSumInner(remainNum - p / 2) + (remainNum - p / 2);
		}
		
		return leftPart + rightPart;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		/*
		 * 1 - 1개
		 * 총 1개
		 * -----
		 * 2 - 1개
		 * 3 - 2개
		 * 총 3개
		 * -----
		 * 4 - 1개
		 * 5 - 2개
		 * 6 - 2개
		 * 7 - 3개
		 * -----
		 * 8 - 1개
		 * 9 - 2개
		 * 10 - 2개
		 * 11 - 3개
		 * 12 - 2개
		 * 13 - 3개
		 * 14 - 3개
		 * 15 - 4개
		 * -----
		 * 16 - 1개
		 * 17 - 2개
		 * 18 - 2개
		 * 19 - 3개
		 * 20 - 2개
		 * 21 - 3개
		 * 22 - 3개
		 * 23 - 4개
		 * 24 - 2개
		 * 25 - 3개
		 * 26 - 3개
		 * 27 - 4개
		 * 28 - 3개
		 * 29 - 4개
		 * 30 - 4개
		 * 31 - 5개  
		 * dp[i]: 비트가 i개 있을 때 1의 개수의 총합 i >= 1
		 * dp[i + 1] = dp[i] * 2 + 2 ^ (i - 1)
		 */
		dp = new long[55];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<dp.length;i++) {
			dp[i] = dp[i-1] * 2 + (long)Math.pow(2, i - 2);
		}
		long remainA = A;
		int aPow = 0;
		while(remainA > 0) {
			aPow++;
			remainA /= 2;
		}
		long remainB = B;
		int bPow = 0;
		while(remainB > 0) {
			bPow++;
			remainB /= 2;
		}
		// System.out.println(aPow + " " + bPow);
		// System.out.println(getPartialSum(A - 1, aPow));
		// System.out.println(dp[aPow] - getPartialSum(A - 1, aPow));
		// System.out.println(getPartialSum(B, bPow));
		for(int i=1; i<= 5;i++) {
			// System.out.println("dp[" + i + "]: " + dp[i]);
		}
		if(A == B) {
			String binary = Long.toBinaryString(A);
			long ans = 0;
			for(int i=0;i<binary.length();i++) {
				if(binary.charAt(i) == '1') {
					ans++;
				}
			}
			System.out.println(ans);
		} else {
			long ans = 0;
			if(aPow == bPow) {
				// System.out.println("aPow == bPow");
				// System.out.println(getPartialSum(B, bPow));
				// System.out.println(getPartialSum(A - 1, aPow));
				ans = getPartialSum(B, bPow) - getPartialSum(A - 1, aPow);
			} else {
				ans = (dp[aPow] - getPartialSum(A - 1, aPow)) + getPartialSum(B, bPow);
				for(int i=aPow + 1; i <= bPow - 1;i++) {
					ans += dp[i];
				}
			}
			System.out.println(ans);
		}
	}  
}