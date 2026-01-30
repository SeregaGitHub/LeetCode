package easy._101_symmetric_tree;

public class Solution {
    public static void main(String[] args) {

        TreeNode treeNode3l = new TreeNode(3);
        TreeNode treeNode4l = new TreeNode(4);
        TreeNode treeNode3r = new TreeNode(3);
        TreeNode treeNode4r = new TreeNode(4);
        TreeNode treeNode2r = new TreeNode(2, treeNode4r, treeNode3r);
        TreeNode treeNode2l = new TreeNode(2, treeNode3l, treeNode4l);
        TreeNode treeNode1 = new TreeNode(1, treeNode2l, treeNode2r);

        System.out.println(isSymmetric(treeNode1));
    }

    private static boolean isSymmetric(TreeNode root) {
//        if (root == null) return false;
//        if (root.left == null && root.right == null) return true;
//        if (root.left == null || root.right == null) return false;

        return check(root.left, root.right);
    }

    private static boolean check(TreeNode l, TreeNode r) {
        if (r == null && l == null) return true;
        if (r == null || l == null) return false;
        if (r.val != l.val) return false;
        return check(l.left, r.right) && check(l.right, r.left);
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
