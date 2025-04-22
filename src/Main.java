import java.io.*;
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
}
public class Main {
    private static ArrayList<Integer> lis;
    private static TreeNode root;
    private static TreeNode makeBinarySearchTree(int start, int end) {
        if(start > end) {
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = lis.get(start);
        int mid = -1;
        for(int i=start;i<=end;i++) {
            if(lis.get(i) > lis.get(start)) {
                mid = i - 1;
                break;
            }
        }
        if(mid != -1) {
            node.left = makeBinarySearchTree(start + 1, mid);
            node.right = makeBinarySearchTree(mid + 1, end);
        } else {
            if(lis.get(end) > lis.get(start)) {
                node.right = makeBinarySearchTree(start + 1, end);
            } else {
                node.left = makeBinarySearchTree(start + 1, end);
            }
        }
        return node;
    }
    private static StringBuilder sb = new StringBuilder();
    private static void postOrder(TreeNode cur) {
        if(cur.left != null) {
            postOrder(cur.left);
        }
        if(cur.right != null) {
            postOrder(cur.right);
        }
        sb.append(cur.val).append("\n");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        lis = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            lis.add(Integer.parseInt(line));
        }
        root = makeBinarySearchTree(0, lis.size() - 1);
        postOrder(root);
        System.out.println(sb);
    }
}