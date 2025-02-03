import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static int N, M;
	private static Set<String> s1;
	private static Set<String> s2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		s1 = new HashSet<>();
		s2 = new HashSet<>();
		for(int i = 0; i < N; i++) {
			s1.add(br.readLine());
		}
		for(int i = 0; i < M; i++) {
			s2.add(br.readLine());
		}
		s1.retainAll(s2);
		List<String> result = s1.stream().sorted().collect(Collectors.toList());
		System.out.println(result.size());
		for(String s : result) {
			System.out.println(s);
		}
	}
}