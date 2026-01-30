package easy._145_binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode3, null);
        TreeNode treeNode1 = new TreeNode(1, null, treeNode2);

        List<Integer> result = postorderTraversal(treeNode1);
        result.forEach(integer -> System.out.print(integer + " "));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        return dfs(root, list);
    }

    private static List<Integer> dfs(TreeNode root, List<Integer> list) {

        if (root.left != null) {
            dfs(root.left, list);
        }
        if (root.right != null) {
            dfs(root.right, list);
        }

        list.add(root.val);

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
