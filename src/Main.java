import java.io.*;
import java.util.*;

public class Main {
	private static int N, M;
	private static Map<Integer, Integer> map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			int a = Integer.parseInt(st.nextToken());
			if(map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}
		}
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			int a = Integer.parseInt(st.nextToken());
			if(map.containsKey(a)) {
				sb.append(map.get(a)).append(" ");
			} else {
				sb.append("0 ");
			}
		}
		System.out.println(sb);
	}
}