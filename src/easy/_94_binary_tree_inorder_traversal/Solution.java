package easy._94_binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode9 = new TreeNode(9, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode8 = new TreeNode(8, treeNode9, null);
        TreeNode treeNode5 = new TreeNode(5, treeNode6, treeNode7);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode3 = new TreeNode(3, null, treeNode8);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        List<Integer> list = inorderTraversal(treeNode1);
        list.forEach(integer -> System.out.print(integer + " "));

        //inorderTraversalPrint(treeNode1);
        System.out.println("\n========================================");
        List<Integer> list1 = new ArrayList<>();
        inorderTraversalPrint2(treeNode1, list1);
        list1.forEach(integer -> System.out.print(integer + " "));

    }

    public static void inorderTraversalPrint2(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            inorderTraversalPrint2(root.left, list);
        }
        //System.out.print(root.val + " ");
        list.add(root.val);
        if (root.right != null) {
            inorderTraversalPrint2(root.right, list);
        }
    }

    public static void inorderTraversalPrint(TreeNode root) {
        if (root.left != null) {
            inorderTraversalPrint(root.left);
        }
        System.out.print(root.val + " ");
        if (root.right != null) {
            inorderTraversalPrint(root.right);
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
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
