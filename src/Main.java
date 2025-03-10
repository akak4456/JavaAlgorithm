import java.io.*;
import java.util.*;
public class Main {
	private static int T;
	private static String p;
	private static int n;
	private static int[] arr;
	private static boolean reversed;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testCase = 0; testCase < T; testCase++) {
			p = br.readLine();
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			reversed = false;
			String a = br.readLine();
			String sub = a.substring(1, a.length() - 1);
			String[] subSplit = sub.split(",");
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(subSplit[i]);
			}
			boolean isError = false;
			int start = 0;
			int end = n - 1;
			for(int i=0;i<p.length();i++) {
				if(p.charAt(i) == 'R') {
					reversed = !reversed;
				} else if(p.charAt(i) == 'D') {
					if(start > end) {
						isError = true;
						break;
					}
					if(!reversed) {
						start++;
					} else {
						end--;
					}
				}
			}
			if(isError) {
				sb.append("error\n");
			} else {
				sb.append("[");
				if (!reversed) {
					for (int i = start; i <= end; i++) {
						sb.append(arr[i]);
						if (i < end) {
							sb.append(",");
						}
					}
				} else {
					for (int i = end; i >= start; i--) {
						sb.append(arr[i]);
						if (i > start) {
							sb.append(",");
						}
					}
				}
				sb.append("]\n");
			}
		}
		System.out.println(sb);
	}
}