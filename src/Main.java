import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int minusIdx = -1;
		Queue<Integer> operand = new LinkedList<>();
		Queue<Character> opcode = new LinkedList<>();
		int operandStartIdx = 0;
		for (int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '-' || line.charAt(i) == '+') {
				operand.add(Integer.parseInt(line.substring(operandStartIdx, i)));
				opcode.add(line.charAt(i));
				operandStartIdx = i+1;
			}
			if(line.charAt(i) == '-' && minusIdx == -1) {
				minusIdx = opcode.size() - 1;
			}
		}
		operand.add(Integer.parseInt(line.substring(operandStartIdx)));
		int result1 = 0;
		if(minusIdx != -1) {
			result1 = operand.poll();
			for(int i=0;i<minusIdx;i++) {
				result1 += operand.poll();
				opcode.poll();
			}
			opcode.poll();
		}
		int result2 = operand.poll();
		while(!opcode.isEmpty()) {
			Character op = opcode.poll();
			if(op == '+') {
				result2 += operand.poll();
			} else {
				result2 += operand.poll();
			}
		}
		if(minusIdx != -1) {
			System.out.println(result1 - result2);
		} else {
			System.out.println(result2);
		}
	}
}