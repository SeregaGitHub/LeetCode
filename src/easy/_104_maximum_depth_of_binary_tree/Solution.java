package easy._104_maximum_depth_of_binary_tree;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode15 = new TreeNode(15, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);
        TreeNode treeNode9 = new TreeNode(9, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode9, treeNode20);

        System.out.println(maxDepth(treeNode3));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        //return l > r ? l + 1 : r + 1;
        return Math.max(l, r) + 1;
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
