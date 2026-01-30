package easy._112_path_sum;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode2 = new TreeNode(2, null, null);
        TreeNode treeNode11 = new TreeNode(11, treeNode7, treeNode2);
        TreeNode treeNode4 = new TreeNode(4, treeNode11, null);
        TreeNode treeNode1 = new TreeNode(1, null, null);
        TreeNode treeNode44 = new TreeNode(4, null, treeNode1);
        TreeNode treeNode13 = new TreeNode(13, null, null);
        TreeNode treeNode8 = new TreeNode(8, treeNode13, treeNode44);
        TreeNode treeNode5 = new TreeNode(5, treeNode4, treeNode8);

        System.out.println(hasPathSum(treeNode5, 22));
        System.out.println(hasPathSum(null, 22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        int updatedTargetSum = targetSum - root.val;

        boolean l = hasPathSum(root.left, updatedTargetSum);
        boolean r = hasPathSum(root.right, updatedTargetSum);

        return l || r;
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
