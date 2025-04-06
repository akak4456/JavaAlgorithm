import java.io.*;
import java.util.*;
class TreeNode {
    TreeNode left;
    TreeNode right;
    char val;
    public TreeNode(char val) {
        this.val = val;
    }
}
public class Main {
    private static int N;
    private static TreeNode[] nodes;
    private static void preorder(TreeNode root) {
        System.out.print(root.val);
        if(root.left != null) {
            preorder(root.left);
        }
        if(root.right != null) {
            preorder(root.right);
        }
    }
    private static void inorder(TreeNode root) {
        if(root.left != null) {
            inorder(root.left);
        }
        System.out.print(root.val);
        if(root.right != null) {
            inorder(root.right);
        }
    }
    private static void postorder(TreeNode root) {
        if(root.left != null) {
            postorder(root.left);
        }
        if(root.right != null) {
            postorder(root.right);
        }
        System.out.print(root.val);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new TreeNode[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new TreeNode((char)('A' + i));
        }
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if(left != '.') {
                nodes[root - 'A'].left = nodes[left - 'A'];
            }
            if(right != '.') {
                nodes[root - 'A'].right = nodes[right - 'A'];
            }
        }
        preorder(nodes[0]);
        System.out.println();
        inorder(nodes[0]);
        System.out.println();
        postorder(nodes[0]);
        System.out.println();
    }

}