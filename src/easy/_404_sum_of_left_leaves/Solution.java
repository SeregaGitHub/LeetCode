package easy._404_sum_of_left_leaves;

public class Solution {
    public static void main(String[] args) {

        TreeNode treeNode15 = new TreeNode(15, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode9 = new TreeNode(9, null, null);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);
        TreeNode treeNode3 = new TreeNode(3, treeNode9, treeNode20);

        System.out.println(sumOfLeftLeaves(treeNode3));
    }

    public static int sumOfLeftLeaves(TreeNode root) {

        if (root == null) return 0;

        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);

        int current = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            current = root.left.val;
        }

        return current + leftSum + rightSum;
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
