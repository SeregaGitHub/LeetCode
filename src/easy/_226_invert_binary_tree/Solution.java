package easy._226_invert_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

        TreeNode treeNode9p = new TreeNode(9, null, null);
        TreeNode treeNode6p = new TreeNode(6, null, null);
        TreeNode treeNode7p = new TreeNode(7, treeNode6p, treeNode9p);
        TreeNode treeNode1p = new TreeNode(1, null, null);
        TreeNode treeNode3p = new TreeNode(3, null, null);
        TreeNode treeNode2p = new TreeNode(2, treeNode1p, treeNode3p);
        TreeNode treeNode4p = new TreeNode(4, treeNode2p, treeNode7p);

        printTree(treeNode4p);
        System.out.println("\n=====================================");
        printTree(invertTree(treeNode4p));
        invertTree(null);
    }

    public static TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        if (root.left != null || root.right != null) {

            TreeNode buffer = root.left;
            root.left = root.right;
            root.right = buffer;

            invertTree(root.left);
            invertTree(root.right);
        }

        return root;
    }

    private static void printTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.print(treeNode.val + " ");

            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }

            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
