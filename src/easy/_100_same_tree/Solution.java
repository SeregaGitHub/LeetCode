package easy._100_same_tree;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode9p = new TreeNode(9, null, null);
        TreeNode treeNode7p = new TreeNode(7, null, null);
        TreeNode treeNode6p = new TreeNode(6, null, null);
        TreeNode treeNode8p = new TreeNode(8, treeNode9p, null);
        TreeNode treeNode5p = new TreeNode(5, treeNode6p, treeNode7p);
        TreeNode treeNode4p = new TreeNode(4, null, null);
        TreeNode treeNode3p = new TreeNode(3, null, treeNode8p);
        TreeNode treeNode2p = new TreeNode(2, treeNode4p, treeNode5p);
        TreeNode treeNode1p = new TreeNode(1, treeNode2p, treeNode3p);

        TreeNode treeNode9q = new TreeNode(9, null, null);
        TreeNode treeNode7q = new TreeNode(7, null, null);
        TreeNode treeNode6q = new TreeNode(6, null, null);
        TreeNode treeNode8q = new TreeNode(8, treeNode9q, null);
        TreeNode treeNode5q = new TreeNode(5, treeNode6q, treeNode7q);
        TreeNode treeNode4q = new TreeNode(4, null, null);
        TreeNode treeNode3q = new TreeNode(3, null, treeNode8q);
        TreeNode treeNode2q = new TreeNode(2, treeNode4q, treeNode5q);
        TreeNode treeNode1q = new TreeNode(1, treeNode2q, treeNode3q);

        System.out.println(isSameTree(treeNode1p, treeNode1q));

        System.out.println("\n=========================================\n");

//        System.out.println(countNodes(treeNode1p));
//        System.out.println(countNodes(null));

        System.out.println(countNodes(treeNode1p));
    }

    public static int countNodes(TreeNode root) {

        if (root == null) return 0;

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return 1 + leftCount + rightCount;


        /*int count = 0;
        if (root == null) return count;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            count++;
            if (currNode.left != null) {
                queue.add(currNode.left);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
            }
        }

        return count;*/
    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
