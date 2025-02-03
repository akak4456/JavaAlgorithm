import java.io.*;
import java.util.*;

public class Main {
	private static int N, M;
	private static String[] arr;
	private static Map<String, Integer> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new String[N + 1];
		map = new HashMap<>();
		for(int i=1;i<=N;i++) {
			arr[i] = br.readLine();
			map.put(arr[i], i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=M;i++) {
			String s = br.readLine();
			if(s.charAt(0) >= '0' && s.charAt(0) <= '9') {
				sb.append(arr[Integer.parseInt(s)]).append("\n");
			} else {
				sb.append(map.get(s)).append("\n");
			}
		}
		System.out.println(sb);
	}
}