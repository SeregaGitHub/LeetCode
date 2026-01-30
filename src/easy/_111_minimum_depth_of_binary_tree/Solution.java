package easy._111_minimum_depth_of_binary_tree;

public class Solution {

    public static void main(String[] args) {
        //minDepth(new TreeNode());
    }

    private static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = minDepth(root.left);
        int r = minDepth(root.right);

        return (l == 0 || r == 0) ? l + r + 1 : Math.min(l, r) + 1;
    }

    private static class TreeNode {
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
