import java.io.*;
import java.util.*;

public class Main {
	private static boolean isNumber(String s) {
		for (char x : s.toCharArray()){
			if (!Character.isDigit(x)){
				return false;
			}
		}
		return true;
	}
	private static void printFizzBuzz(int num) {
		if(num % 3 == 0 && num % 5 == 0){
			System.out.println("FizzBuzz");
		} else if(num % 3 == 0){
			System.out.println("Fizz");
		} else if(num % 5 == 0){
			System.out.println("Buzz");
		} else {
			System.out.println(num);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line1 = br.readLine();
		String line2 = br.readLine();
		String line3 = br.readLine();
		if(isNumber(line1)){
			int a = Integer.parseInt(line1);
			printFizzBuzz(a + 3);
		} else if(isNumber(line2)){
			int a = Integer.parseInt(line2);
			printFizzBuzz(a + 2);
		} else if(isNumber(line3)){
			int a = Integer.parseInt(line3);
			printFizzBuzz(a + 1);
		}
	}
}