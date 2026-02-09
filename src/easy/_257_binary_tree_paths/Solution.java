package easy._257_binary_tree_paths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, null, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        List<String> result = binaryTreePaths(treeNode1);
        result.forEach(System.out::println);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> allWays = findAllWays(root);
        List<String> result = new ArrayList<>(allWays.size());

        for (List<Integer> way: allWays) {
            StringBuilder sb = new StringBuilder();
            way.forEach(integer -> sb.append(integer).append("->"));


            sb.delete(sb.length() - 2, sb.length());
            result.add(sb.toString());
        }
        return result;
    }

    private static List<List<Integer>> findAllWays(TreeNode root) {
        if (root == null) return new LinkedList<>();

        List<List<Integer>> left = findAllWays(root.left);
        List<List<Integer>> right = findAllWays(root.right);
        left.addAll(right);

        if (left.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            left.add(list);
        } else {
            left.forEach(item -> item.addFirst(root.val));
        }

        return left;
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
