import java.util.*;

public class InorderMorris {
    public static class TreeNode {
        int val;
        Test.TreeNode left;
        Test.TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // this is different from regular Inorder Morris algorithm
    // inspired by Preorder Morris
    public static List<Integer> inorderMorris(Test.TreeNode root) {
        List<Integer> traversal = new ArrayList<>();

        Test.TreeNode node = root;

        while (node != null) {
            // go left then go all the way right
            if (node.left == null) {
                traversal.add(node.val);
                node = node.right;
            } else {
                Test.TreeNode pre = node.left;
                while (pre.right != null && pre.right != node) {
                    pre = pre.right;
                }

                // find the rightmost
                // make a circle
                if (pre.right == null) {
                    pre.right = node;
                    node = node.left;
                }

                if (pre.right == node) {
                    pre.right = null;
                    traversal.add(node.val);
                    node = node.right;
                }
            }
        }

        return traversal;
    }

    public static void main(String[] args) {
        Test.TreeNode root = new Test.TreeNode(1);
        root.left = new Test.TreeNode(2);
        root.right = new Test.TreeNode(3);
        root.left.left = new Test.TreeNode(4);
        root.left.right = new Test.TreeNode(5);
        root.right.left = new Test.TreeNode(6);
        root.right.right = new Test.TreeNode(7);

        List<Integer> list = inorderMorris(root);
    }
}
