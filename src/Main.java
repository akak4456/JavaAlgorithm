import java.io.*;
import java.util.*;

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
		return Integer.compare(this.first, o.first);
	}
	
}

class IntKeyPair<V> implements Comparable<IntKeyPair<V>> {
	private int first;
	private V second;
	
	public IntKeyPair(int first, V second) {
		this.first = first;
		this.second = second;
	}
	
	public int getFirst() {
		return first;
	}
	
	public V getSecond() {
		return second;
	}

	@Override
	public int compareTo(IntKeyPair<V> o) {
		return Integer.compare(this.first, o.first);
	}
	
}

interface Baekjoon {
	void input() throws Exception;
	void solve();
	void output();
}
/*
 * 문제 풀이는 Baekjoon 메소드 구현을 바꾸는 식으로 해서 할것
 */
public class Main implements Baekjoon {
	private int N;
	private int[] A;
	private int[] B;
	private int[] C;
	private int[] D;
	private long[] AB;
	private long[] CD;
	private long ans = 0;
	@Override 
	public void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		C = new int[N];
		D = new int[N];
		AB = new long[N * N];
		CD = new long[N * N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
	}
	@Override
	public void solve() {
		int abIdx = 0;
		int cdIdx = 0;
		for(int aIdx = 0; aIdx < N; aIdx++) {
			for(int bIdx = 0; bIdx < N; bIdx++) {
				long sum = (long)A[aIdx] + (long)B[bIdx];
				AB[abIdx++] = sum;
			}
		}
		for(int cIdx = 0; cIdx < N; cIdx++) {
			for(int dIdx = 0; dIdx < N; dIdx++) {
				long sum = (long)C[cIdx] + (long)D[dIdx];
				CD[cdIdx++] = sum;
			}
		}
		Arrays.sort(CD);
		for(int i=0;i<AB.length;i++) {
			int result = Arrays.binarySearch(CD, -AB[i]);
			int lowerIdx = lowerBound(CD, -AB[i]);
			int upperIdx = upperBound(CD, -AB[i]);
			if(CD[lowerIdx] == -AB[i]) {
				// System.out.println(lowerIdx + " " + upperIdx);
				ans += upperIdx - lowerIdx + 1;
			}
		}
	}
	
	public static int upperBound(long[] arr, long value){
	    int max = arr.length;
	    int min = 0;
	    while(min<max){
	        int mid = (min+max)/2;
	        if(value<arr[mid]){
	            max = mid;
	        }else{
	            min = mid+1;
	        }
	    }
	    return min-1;
	}
	public static int lowerBound(long[] arr, long value){
	    int max = arr.length;
	    int min = 0;
	    while(min<max){
	        int mid = (min+max)/2;
	        if(value > arr[mid]){
	            min = mid+1;
	        }else{
	            max = mid;
	        }
	    }
	    return min;
	}
	@Override
	public void output() {
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.input(); // 문제를 입력 받는 부분
		main.solve(); // 문제를 푸는 부분
		main.output(); // 문제를 풀었으면 그 결과를 출력하는 부분
	}  
}