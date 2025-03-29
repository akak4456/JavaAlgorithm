import java.io.*;
import java.util.*;

class N implements Comparable<N> {
    int arr[];
    public N(ArrayList<Integer> list) {
        this.arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.arr[i] = list.get(i);
        }
    }

    @Override
    public int compareTo(N o) {
        for(int i=0;i<this.arr.length;i++) {
            if(this.arr[i] != o.arr[i]) return Integer.compare(this.arr[i], o.arr[i]);
        }
        return 0;
    }
}

public class Main {
    private static int N, M;
    private static int[] arr;
    private static TreeSet<N> set;
    private static void solve(ArrayList<Integer> list, int start) {
        if(list.size() == M) {
            set.add(new N(list));
            return;
        }
        for(int i=start;i<N;i++) {
            list.add(arr[i]);
            solve(list, i);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        set = new TreeSet<>();
        solve(new ArrayList<>(), 0);
        StringBuilder sb = new StringBuilder();
        for (N s : set) {
            for(int i=0;i<M;i++) {
              sb.append(s.arr[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}