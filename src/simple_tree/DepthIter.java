package simple_tree;

import java.util.Stack;

public class DepthIter {
    public static void main(String[] args) {
        Tree tree6 = new Tree(6, null, null);
        Tree tree4 = new Tree(4, null, tree6);
        Tree tree9 = new Tree(9, null, null);
        Tree tree7 = new Tree(7, tree4, tree9);

        Tree tree28 = new Tree(28, null, null);
        Tree tree38 = new Tree(38, null, null);
        Tree tree52 = new Tree(52, null, null);
        Tree tree31 = new Tree(31, tree28, null);
        Tree tree40 = new Tree(40, tree38, tree52);
        Tree tree35 = new Tree(35, tree31, tree40);

        Tree tree20 = new Tree(20, tree7, tree35);

        /*                     TreeSum = 270

                                    20
                         7                          35
                    4         9               31           40
                     6                     28           38    52
         */
        System.out.println("= " + depthIt(tree20));
    }

    private static int depthIt(Tree root) {
        if (root == null) return 0;

        int result = 0;
        Stack<Tree> stack = new Stack<>();
        stack.push(root);
        // 20 35 40 52 38 31 28 7 9 4 6 = 270
        while (!stack.isEmpty()) {
            Tree tree = stack.pop();
            result += tree.value;
            System.out.print(tree.value + " ");

            if (tree.left != null) {
                stack.push(tree.left);
            }
            if (tree.right != null) {
                stack.push(tree.right);
            }
        }

        return result;
    }
}
