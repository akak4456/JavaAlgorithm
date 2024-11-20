import java.io.*;
import java.util.*;
class Node {
	char ch;
	Node left, right;
}
public class Main {
	private static int N;
	private static Node[] nodes;
	private static String preorder(Node root) {
		String ret = root.ch + "";
		if (root.left != null) {
			ret += preorder(root.left);
		}
		if(root.right != null) {
			ret += preorder(root.right);
		}
		return ret;
	}
	private static String inorder(Node root) {
		String ret = "";
		if(root.left != null) {
			ret += inorder(root.left);
		}
		ret += root.ch;
		if(root.right != null) {
			ret += inorder(root.right);
		}
		return ret;
	}
	private static String postorder(Node root) {
		String ret = "";
		if(root.left != null) {
			ret += postorder(root.left);
		}
		if(root.right != null) {
			ret += postorder(root.right);
		}
		ret += root.ch;
		return ret;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node();
			nodes[i].ch = (char) (i + 'A');
		}
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			char b = st.nextToken().charAt(0);
			char c = st.nextToken().charAt(0);
			if(b != '.') {
				nodes[a - 'A'].left = nodes[b - 'A'];
			}
			if(c != '.') {
				nodes[a-'A'].right = nodes[c - 'A'];
			}
		}
		System.out.println(preorder(nodes[0]));
		System.out.println(inorder(nodes[0]));
		System.out.println(postorder(nodes[0]));
	}
}