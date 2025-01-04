import java.io.*;
import java.util.*;

public class Main {
	private static int T;
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		while(in.hasNextInt()) {
			int A = in.nextInt();
			int B = in.nextInt();
			System.out.println(A + B);
		}

		in.close();
	}
}