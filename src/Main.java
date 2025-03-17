import java.io.*;
import java.util.*;
public class Main {
	private static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testCase = 0; testCase < T;testCase++) {
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();
			for(int op=0;op<k;op++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String opCode = st.nextToken();
				if("I".equals(opCode)) {
					int operand = Integer.parseInt(st.nextToken());
					map.put(operand, map.getOrDefault(operand, 0) + 1);
				} else {
					if(map.size() == 0) continue;
					int operand = Integer.parseInt(st.nextToken());
					int num;
					if(operand == 1) {
						num = map.lastKey();
					} else {
						num = map.firstKey();
					}
					if(map.put(num, map.get(num) - 1) == 1) {
						map.remove(num);
					}
				}
			}
			if(map.size() == 0) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey() + " " + map.firstKey() + "\n");
			}
		}
		System.out.println(sb);
	}
}