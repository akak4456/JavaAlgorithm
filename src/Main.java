import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static String[] strings;
	private static String[] mergeSort(int startIdx, int endIdx) {
		String[] ret = new String[endIdx - startIdx + 1];
		if(startIdx == endIdx) {
			ret[0] = strings[startIdx];
			return ret;
		}
		int mid = (startIdx + endIdx) / 2;
		String[] ret1 = mergeSort(startIdx, mid);
		String[] ret2 = mergeSort(mid+1, endIdx);
		int ret1Idx = 0;
		int ret2Idx = 0;
		int retIdx = 0;
		while(ret1Idx < ret1.length && ret2Idx < ret2.length) {
			if(ret1[ret1Idx].length() < ret2[ret2Idx].length()) {
				ret[retIdx] = ret1[ret1Idx];
				retIdx++;
				ret1Idx++;
			} else if(ret1[ret1Idx].length() > ret2[ret2Idx].length()) {
				ret[retIdx] = ret2[ret2Idx];
				retIdx++;
				ret2Idx++;
			} else {
				if(ret1[ret1Idx].compareTo(ret2[ret2Idx]) < 0) {
					ret[retIdx] = ret1[ret1Idx];
					retIdx++;
					ret1Idx++;
				} else {
					ret[retIdx] = ret2[ret2Idx];
					retIdx++;
					ret2Idx++;
				}
			}
		}
		while(ret1Idx < ret1.length) {
			ret[retIdx] = ret1[ret1Idx];
			retIdx++;
			ret1Idx++;
		}
		while(ret2Idx < ret2.length) {
			ret[retIdx] = ret2[ret2Idx];
			retIdx++;
			ret2Idx++;
		}
		return ret;
	}
	public static void main(String[] args) throws Exception {
		// 입력 최적화를 위해서 Scanner 대신에 BufferedReader, StringTokenizer 를
		// 혼합하는 방식으로 사용함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(br.readLine());
		strings = new String[N];
		for(int i=0;i<N;i++) {
			strings[i] = br.readLine();
		}
		String[] ret = mergeSort(0, N - 1);
		for(int i=0;i<N;i++) {
			if(i > 0 && ret[i].equals(ret[i-1])) continue;
			System.out.println(ret[i]);
		}
	}
}