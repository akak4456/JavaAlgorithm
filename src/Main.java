import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static int N, M;
	private static Map<String, String> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map.put(st.nextToken(), st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String line = br.readLine();
			sb.append(map.get(line)).append("\n");
		}
		System.out.println(sb);
	}
}