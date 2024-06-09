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
		if(Integer.compare(this.second, o.second) == 0) {
			return Integer.compare(this.first, o.first);
		}
		return Integer.compare(this.second, o.second);
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

class Input {
	private boolean isRandomMode;
	private int curParsedIdx;
	private ArrayList<String> parsed;
	public Input(boolean isRandomMode) throws Exception {
		this.isRandomMode = isRandomMode;
		this.curParsedIdx = 0;
		this.parsed = new ArrayList<>();
		if(!isRandomMode) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = "";
			while((line = br.readLine()) != null) {
				if(line.isBlank()) break;
				StringTokenizer st = new StringTokenizer(line, " ");
				while(st.hasMoreTokens()) {
					parsed.add(st.nextToken());
				}
			}
		}
	}
	
	public int nextInt(int minVal, int maxVal) {
		if(isRandomMode) {
			Random random = new Random();
			int ret = random.nextInt(maxVal - minVal + 1) + minVal;
			System.out.println(ret);
			return ret;
		} else {
			return Integer.parseInt(parsed.get(curParsedIdx++));
		}
	}
	
	public int[] nextIntArray(int startIdx, int size, int minVal, int maxVal) {
		int[] ret = new int[size + startIdx];
		for(int idx = startIdx; idx<ret.length;idx++) {
			if(isRandomMode) {
				Random random = new Random();
				ret[idx] = random.nextInt(maxVal - minVal + 1) + minVal;
				System.out.print(ret[idx] + " ");
				if(idx == ret.length - 1) {
					System.out.println();
				}
			} else {
				ret[idx] = Integer.parseInt(parsed.get(curParsedIdx++));
			}
		}
		return ret;
	}
}

interface Baekjoon {
	void input(boolean isRandomMode) throws Exception;
	void solve();
	void output();
}
/*
 * 문제 풀이는 Baekjoon 메소드 구현을 바꾸는 식으로 해서 할것
 */
public class Main implements Baekjoon {
	private int N;
	private int[] A;
	private int M;
	private int[] B;
	private String[][] dp;
	@Override
	public void input(boolean isRandomMode) throws Exception {
		Input input = new Input(isRandomMode);
		N = input.nextInt(1, 100);
		A = input.nextIntArray(1, N, 1, 100);
		M = input.nextInt(1, 100);
		B = input.nextIntArray(1, M, 1, 100);
	}
	@Override
	public void solve() {
		dp = new String[M+1][N+1];
		for(int i=0;i<=M;i++) {
			for(int j=0;j<=N;j++) {
				dp[i][j] = "";
			}
		}
		for(int row=1;row<=M;row++) {
			for(int col=1;col <=N; col++) {
				if(B[row] == A[col]) {
					if(dp[row-1][col-1].isBlank()) {
						dp[row][col] = B[row] + "";
					} else {
						String target = dp[row-1][col-1] + "," +B[row];
						String[] splited = dp[row-1][col-1].split(",");
						for(int i=splited.length - 1;i>0;i--) {
							String joined = "";
							for(int j = 0; j<i;j++) {
								joined += splited[j];
								joined += ",";
							}
							joined += B[row];
							if(compare(joined, target)) {
								target = joined;
							}
						}
						if(compare(B[row]+"", target)) {
							target = B[row] + "";
						}
						dp[row][col] = target;
					}
				} else {
					if(compare(dp[row-1][col], dp[row][col - 1])) {
						dp[row][col] = dp[row-1][col];
					} else {
						dp[row][col] = dp[row][col - 1];
					}
				}
			}
		}
	}
	@Override
	public void output() {
		String[] ans = dp[M][N].split(",");
		if(ans[0].isBlank()) {
			System.out.println("0");
		} else {
			System.out.println(ans.length);
			for(int i=0;i<ans.length;i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
		}
	}
	/*
	 * target1 이 target2 보다 사전순으로 뒤이면 true 아니면 false
	 */
	private boolean compare(String target1, String target2) {
		String[] arr1 = target1.split(",");
		String[] arr2 = target2.split(",");
		if(arr1[0].isBlank()) {
			arr1 = new String[0];
		}
		if(arr2[0].isBlank()) {
			arr2 = new String[0];
		}
		int maxLen = Math.min(arr1.length, arr2.length);
		for(int i=0;i<maxLen;i++) {
			if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])) {
				return true;
			} else if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])) {
				return false;
			}
		}
		return arr1.length > arr2.length;
	}
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.input(false); // true Random 모드, false System.in 에서 직접 입력을 받는 모드
		main.solve(); // 문제를 푸는 부분
		main.output(); // 문제를 풀었으면 그 결과를 출력하는 부분
	}  
}