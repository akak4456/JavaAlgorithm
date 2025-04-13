import java.io.*;
import java.util.*;
public class Main {
    private static int N, M;
    private static int truthCnt;
    private static int[] truth;
    private static ArrayList<ArrayList<Integer>> party;
    private static int[] root;
    private static int[] rank;
    private static int find(int x) {
        if(root[x] == x){
            return x;
        } else {
            root[x] = find(root[x]);
            return root[x];
        }
    }
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) {
            return;
        }
        if(rank[x] < rank[y]) {
            root[x] = y;
        } else {
            root[y] = x;
            if(rank[x] == rank[y]) {
                rank[x]++;
            }
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        truthCnt = Integer.parseInt(st.nextToken());
        if(truthCnt > 0) {
            truth = new int[truthCnt];
            for(int i=0; i<truthCnt; i++) {
                truth[i] = Integer.parseInt(st.nextToken());
            }
        }
        party = new ArrayList<>();
        for(int i=0; i<M; i++) {
            party.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine(), " ");
            int cnt = Integer.parseInt(st.nextToken());
            for(int j=0; j<cnt; j++) {
                int a = Integer.parseInt(st.nextToken());
                party.get(i).add(a);
            }
        }
        root = new int[N + 1];
        rank = new int[N + 1];
        for(int i=0;i<=N;i++) {
            root[i] = i;
            rank[i] = 0;
        }
        for(int partyNum = 0; partyNum < M; partyNum++) {
            ArrayList<Integer> p = party.get(partyNum);
            for(int i=0; i<p.size(); i++) {
                for(int j=0; j<p.size(); j++) {
                    if(i == j) continue;
                    union(p.get(i), p.get(j));
                }
            }
        }
        int result = 0;
        for(int partyNum = 0; partyNum < M; partyNum++) {
            ArrayList<Integer> p = party.get(partyNum);
            boolean isPossible = true;
            for(int i=0; i<p.size(); i++) {
                for(int j=0; j<truthCnt; j++) {
                    if(find(p.get(i)) == find(truth[j])) {
                        isPossible = false;
                        break;
                    }
                }
                if(!isPossible) {
                    break;
                }
            }
            if(isPossible) {
                result++;
            }
        }
        System.out.println(result);
    }

}