import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    private static String line;
    private static Stack<String> operand = new Stack<>();
    private static Stack<Character> opcode = new Stack<>();
    private static Map<Character, Integer> orderMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        line += ' ';
        int targetIdx = 0;
        orderMap.put('+', 0);
        orderMap.put('-',0);
        orderMap.put('*', 1);
        orderMap.put('/',1);
        orderMap.put('(',2);
        orderMap.put(' ', -2);
        while(targetIdx < line.length()) {
            int order = -1;
            if(orderMap.containsKey(line.charAt(targetIdx))) {
                order = orderMap.get(line.charAt(targetIdx));
            }
            if(order == -1) {
                if(line.charAt(targetIdx) == ')') {
                    order = -2;
                    while(!opcode.isEmpty() && opcode.peek() != '(' && order <= orderMap.get(opcode.peek())) {
                        String a = operand.pop();
                        String b = operand.pop();
                        String newOperand = b + a + opcode.pop();
                        operand.push(newOperand);
                    }
                    opcode.pop();
                } else {
                    operand.push(String.valueOf(line.charAt(targetIdx)));
                }
                targetIdx++;
            } else {
                while(!opcode.isEmpty() && opcode.peek() != '(' && order <= orderMap.get(opcode.peek())) {
                    String a = operand.pop();
                    String b = operand.pop();
                    String newOperand = b + a + opcode.pop();
                    operand.push(newOperand);
                }
                opcode.push(line.charAt(targetIdx));
                targetIdx++;
            }
        }
        System.out.println(operand.pop());
    }
}