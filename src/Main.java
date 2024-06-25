import java.io.*;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.IntConsumer;

class MathLibrary{
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
	
	public static int extendedGCD(int a, int b, int[] xy) {
        if (a == 0) {
            xy[0] = 0;
            xy[1] = 1;
            return b;
        }
        int[] xy1 = {1, 1}; // To store results of recursive call
        int gcd = extendedGCD(b % a, a, xy1);
        xy[0] = xy1[1] - (b / a) * xy1[0];
        xy[1] = xy1[0];
        return gcd;
    }

	/*
	 * 중국인의 나머지 정리를 이용해서 특정 정수를 구하는 것
	 * 그 특정 정수를 t라고 하면
	 * t를 CRTPair[0].first으로 나누었을 때 나머지가 CRTPair[0].second
	 * t를 CRTPair[1].first으로 나누었을 때 나머지가 CRTPair[1].second
	 * ...
	 * t를 CRTPair[pairs.size()-1].first 으로 나누었을 때 나머지가 CRTPair[pairs.size() - 1]
	 * 을 동시에 만족하는 t를 리턴함. 
	 * 만약 만족하는 t가 없다면 -1을 리턴함.
	 */
	public static Integer chineseRemainderTheorem(ArrayList<CRTPair> pairs) {
        int a1 = pairs.get(0).second;
        int m1 = pairs.get(0).first;

        for (int i = 1; i < pairs.size(); i++) {
            int a2 = pairs.get(i).second;
            int m2 = pairs.get(i).first;
            int[] xy = {0, 0};
            int g = extendedGCD(m1, m2, xy);

            if ((a2 - a1) % g != 0) {
                return -1; // No solution exists
            }

            int m1_ = m1 / g;
            int m2_ = m2 / g;
            int mod = m1_ * m2_ * g;
            a1 = (a1 + xy[0] * (a2 - a1) / g % m2_ * m1) % mod;
            if (a1 < 0) a1 += mod;

            m1 = mod;
        }

        return a1;
    }
	
}
class CRTPair {
	int first;
    int second;

    CRTPair(int first, int second) {
        this.first = first;
        this.second = second;
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

class KMP {
	private static ArrayList<Integer> getPi(String target) {
		int m = target.length();
		int j = 0;
		ArrayList<Integer> pi = new ArrayList<>();
		for(int i=0;i<m;i++) {
			pi.add(0);
		}
		for(int i=1;i<m;i++) {
			while(j > 0 && target.charAt(i) != target.charAt(j)) {
				j = pi.get(j - 1);
			}
			if(target.charAt(i) == target.charAt(j)) {
				pi.set(i, ++j);
			}
		}
		return pi;
	}
	public static ArrayList<Integer> kmp(String origin, String target) {
		ArrayList<Integer> ans = new ArrayList<>();
		ArrayList<Integer> pi = getPi(target);
		int n = origin.length();
		int m = target.length();
		int j = 0;
		for(int i=0;i<n;i++) {
			while(j > 0 && origin.charAt(i) != target.charAt(j)) {
				j = pi.get(j-1);
			}
			if(origin.charAt(i) == target.charAt(j)) {
				if(j == m - 1) {
					ans.add(i - m + 1);
					j = pi.get(j);
				} else {
					j++;
				}
			}
		}
		return ans;
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
	private static int D;
	private static long[] arr;
	private static long[][] cnt;
	private static final long MOD= 1_000_000_007;
	private static ArrayList<ArrayList<Integer>> graph;
	private static void printArr() {
		for(int i=0;i<8;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	private static void printCnt() {
		for(int i=0;i<8;i++) {
			System.out.print(i + ":");
			for(int j=0;j<8;j++) {
				System.out.print(cnt[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		D = Integer.parseInt(br.readLine());
		/*
		 4
		# 답 : 11

		32
		# 답 : 622921825
		
		100000000
		# 답 : 261245548
		node 0:정보과학관
		node 1:전산관
		node 2:미래관
		node 3:신양관
		node 4:진리관
		node 5:한경직기념관
		node 6:학생회관
		node 7:형남공학관 
		8
		1 0 0 0 0 0 0 0 
		0 1 1 0 0 0 0 0 
		2 1 1 2 0 1 0 0 
		2 5 6 3 3 3 0 1 
		11 11 13 17 6 13 4 3 
		24 41 52 43 34 39 9 17 
		93 119 147 166 91 146 51 48 
		266 406 524 503 363 452 139 197 
		930 1293 1627 1745 1094 1587 560 591 
		
		930 = 406 + 524
		    = (93 + 147 + 166) + (93 + 119 + 166 + 146)
		 */
		graph = new ArrayList<>();
		for(int i=0;i<8;i++) {
			graph.add(new ArrayList<>());
		}
		graph.get(0).add(1);
		graph.get(0).add(2);
		
		graph.get(1).add(0);
		graph.get(1).add(2);
		graph.get(1).add(3);
		
		graph.get(2).add(0);
		graph.get(2).add(1);
		graph.get(2).add(3);
		graph.get(2).add(5);
		
		graph.get(3).add(1);
		graph.get(3).add(2);
		graph.get(3).add(4);
		graph.get(3).add(5);
		
		graph.get(4).add(3);
		graph.get(4).add(5);
		graph.get(4).add(6);
		
		graph.get(5).add(2);
		graph.get(5).add(3);
		graph.get(5).add(4);
		graph.get(5).add(7);
		
		graph.get(6).add(4);
		graph.get(6).add(7);
		
		graph.get(7).add(5);
		graph.get(7).add(6);
		arr = new long[8];
		cnt = new long[8][8];
		arr[0] = 1;// 0분일 때
		for(int i=1;i<=D;i++) {
			// System.out.println("D:"+i);
			printArr();
			long[] tmp = new long[8];
			long[][] newCnt = new long[8][8];
			for(int j=0;j<8;j++) {
				for(int k=0;k<graph.get(j).size();k++) {
					tmp[graph.get(j).get(k)] = (tmp[graph.get(j).get(k)] + arr[j]) % MOD;
					if(i == 1) {
						cnt[j][graph.get(j).get(k)]++;
					} else {
						for(int t=0;t<8;t++) {
							newCnt[j][graph.get(j).get(k)] += cnt[graph.get(j).get(k)][t];
						}
					}
				}
			}
			arr = tmp;
			if(i > 1) {
				cnt = newCnt;
			}
			if(i == D/2 ) {
				printCnt();
			}
		}
		printArr();
		System.out.println(arr[0]);
	}  
}