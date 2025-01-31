import java.io.*;
import java.util.*;

public class Main {
	private static int M;
	private static int mask;
	private static int allMask;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=20;i++) {
			allMask |= (1<<i);
		}
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String op = st.nextToken();
			switch(op) {
				case "add":
					int operand = Integer.parseInt(st.nextToken());
					mask |= (1 << operand);
					break;
				case "remove":
					operand = Integer.parseInt(st.nextToken());
					mask &= ~(1 << operand);
					break;
				case "check":
					operand = Integer.parseInt(st.nextToken());
					boolean isChecked = (mask & (1 << operand)) > 0;
					if(isChecked) {
						sb.append("1\n");
					} else {
						sb.append("0\n");
					}
					break;
				case "toggle":
					operand = Integer.parseInt(st.nextToken());
					mask ^= (1 << operand);
					break;
				case "all":
					mask = allMask;
					break;
				case "empty":
					mask = 0;
					break;
			}
		}
		System.out.println(sb);
	}
}