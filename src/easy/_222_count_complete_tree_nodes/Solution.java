package easy._222_count_complete_tree_nodes;

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

        System.out.println(countNodes(treeNode1p));
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return 1 + leftCount + rightCount;

        // int count = 0;
        // if (root == null) return count;

        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.add(root);

        // while (!queue.isEmpty()) {
        //     TreeNode currNode = queue.poll();
        //     count++;
        //     if (currNode.left != null) {
        //         queue.add(currNode.left);
        //     }
        //     if (currNode.right != null) {
        //         queue.add(currNode.right);
        //     }
        // }

        // return count;
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
