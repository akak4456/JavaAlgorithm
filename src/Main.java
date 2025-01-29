import java.io.*;
import java.util.*;

public class Main {
	private static int T;
	private static int N, M;
	private static int[] priority;
	private static int[] queue;
	private static int queueFirstPointer;
	private static int queueLastPointer;
	private static int[] result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int testCase = 0; testCase < T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			priority = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				priority[i] = Integer.parseInt(st.nextToken());
			}
			queue = new int[N * 10];
			queueFirstPointer = 0;
			queueLastPointer = N;
			for(int i = 0; i < N; i++) {
				queue[i] = i;
			}
			result = new int[N];
			int order = 1;
			while(queueFirstPointer < queueLastPointer) {
				boolean isPossible = true;
				for(int i = queueFirstPointer + 1; i < queueLastPointer; i++) {
					if(priority[queue[i]] > priority[queue[queueFirstPointer]]) {
						isPossible = false;
						break;
					}
				}
				if(isPossible) {
					result[queue[queueFirstPointer]] = order++;
					queueFirstPointer++;
				}  else {
					queue[queueLastPointer] = queue[queueFirstPointer];
					queueFirstPointer++;
					queueLastPointer++;
				}
			}
			System.out.println(result[M]);
		}
	}
}