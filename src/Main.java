import java.io.*;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
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

class Pair implements Comparable<Pair> {
	private int[] first;
	private int second;
	public Pair(int[] first, int second) {
		this.first = first;
		this.second = second;
	}
	public int[] getFirst() {
		return first;
	}
	public int getSecond() {
		return second;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(second, o.second);
	}
	
}

public class Main {
	private static int N;
	private static int[] A;
	private static int M;
	private static final int INF = 987654321;
	private static int ans = INF;
	private static IntTriple[] op;
	private static Set<Integer> cache;
	private static int getHash(int[] a) {
		int hash = 0;
		for(int i=0;i<a.length;i++) {
			hash += a[i] * (1 << (4*i));
		}
		return hash;
	}
	private static void printArray(int[] array) {
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	private static int[] copyArray(int[] originArray) {
		int[] ret = new int[originArray.length];
		for(int i=0;i<ret.length;i++) {
			ret[i] = originArray[i];
		}
		return ret;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] sortedA = new int[N];
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
			sortedA[i] = A[i];
		}
		Arrays.sort(sortedA);
		int sortedKey = getHash(sortedA);
		M = Integer.parseInt(br.readLine());
		op = new IntTriple[M];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			op[i] = new IntTriple(a - 1,b - 1,c);
		}
		cache = new HashSet<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(copyArray(A), 0));
		while(!pq.isEmpty()) {
			Pair pair = pq.poll();
			// printArray(pair.getFirst());
			int k = getHash(pair.getFirst());
			if(k == sortedKey) {
				ans = pair.getSecond();
				break;
			}
			if(cache.contains(getHash(pair.getFirst()))) continue;
			cache.add(k);
			for(int i=0;i<M;i++) {
				int[] newArr = copyArray(pair.getFirst());
				int tmp = newArr[op[i].getFirst()];
				newArr[op[i].getFirst()] = newArr[op[i].getSecond()];
				newArr[op[i].getSecond()] = tmp;
				pq.add(new Pair(newArr, pair.getSecond() + op[i].getThird()));
			}
		}
		if(ans == INF) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}  
}