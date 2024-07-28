package lib;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 에라토스테네스의 체를 얻는 것
 * 0 ~ N 까지의 수 중에 소수인 수가 boolean 배열 형태로
 * return 된다
 * 예를 들어 boolean[2] == true, boolean[4] == false
 * boolean[5] == true 이다.
 */
class SieveOfEratosthenes {
    private final int N;
    public SieveOfEratosthenes(int N) {
        this.N = N;
    }
    public boolean[] calc() {
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
}
/**
 * 중국인의 나머지 정리를 이용해서 특정 정수를 구하는 것
 * 그 특정 정수를 t라고 하면
 * t를 lib.CRTPair[0].first으로 나누었을 때 나머지가 lib.CRTPair[0].second
 * t를 lib.CRTPair[1].first으로 나누었을 때 나머지가 lib.CRTPair[1].second
 * ...
 * t를 lib.CRTPair[pairs.size()-1].first 으로 나누었을 때 나머지가 lib.CRTPair[pairs.size() - 1]
 * 을 동시에 만족하는 t를 리턴함.
 * 만약 만족하는 t가 없다면 -1을 리턴함.
 */
class ChineseRemainderTheorem {
    static class CRTPair {
        int first;
        int second;

        CRTPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    private final ArrayList<CRTPair> pairs;
    public ChineseRemainderTheorem(ArrayList<CRTPair> pairs) {
        this.pairs = pairs;
    }
    public int calc() {
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

    private static int extendedGCD(int a, int b, int[] xy) {
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
}
/**
 * 이항계수 구하기
 * DP 테이블을 생성해서 구현함
 */
class BinomialCoefficient {
    private final int n;
    private final int k;
    public BinomialCoefficient(int n, int k) {
        this.n = n;
        this.k = k;
    }

    public long calc() {
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

/**
 * 유클리드 호제법을 이용해서 최대 공약수, 최소 공약수를 구함
 */
class Euclidean {
    /**
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

    /**
     * 유클리드 호제법을 이용해서 최소 공배수를 구함
     */
    public static long LCM(long A, long B) {
        long gcd = GCD(A, B);
        long a = A / gcd;
        long b= B / gcd;
        return gcd * a * b;
    }

}

/**
 * 가장 긴 부분증가수열(어떤 임의의 수열이 주어질 때, 이 수열에서 몇 개의 수들을 제거해서 부분수열을 만들 수 있다.
 * 이때 만들어진 부분수열 중 오름차순으로 정렬된 가장 긴 수열을 최장 증가 부분 수열이라 한다.) 을 구하는 가장 효율적인 알고리즘
 */
class LIS {
    private final int[] origin;
    private int LISLength;
    /**
     * origin[i] 가 LIS 에 속하면 isIncludedToLIS[i] = true, 아니면 false 가 된다.
     */
    private boolean[] isIncludedToLIS;
    public LIS(int[] origin) {
        this.origin = origin;
        this.LISLength = 0;
        isIncludedToLIS = null;
    }
    private int lowerBound(int[] array, int start, int end, int value) {
        int low = start;
        int high = end;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int getLISLength() {
        if(isIncludedToLIS == null) {
            calc();
        }
        return LISLength;
    }
    public boolean[] getIsIncludedToLIS() {
        if(isIncludedToLIS == null) {
            calc();
        }
        return isIncludedToLIS;
    }
    private void calc() {
        int[] dest = new int[origin.length];
        int[] result = new int[origin.length];
        dest[0] = origin[0];
        int size = 1;
        for (int i = 1; i < origin.length; i++) {
            int index = lowerBound(dest, 0, size, origin[i]);
            dest[index] = origin[i];
            result[i] = index;
            if (index == size) size++;
        }

        int s = size - 1, i = origin.length-1;
        boolean[] vtd = new boolean[origin.length];
        while (s >= 0) {
            if (result[i] == s) {
                vtd[i] = true;
                s--;
            }
            i--;
        }
        this.LISLength = size;
        this.isIncludedToLIS = vtd;
    }
}

/**
 * Union-Find 알고리즘을 구현함
 */
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

/**
 * KMP 알고리즘을 구현함
 */
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