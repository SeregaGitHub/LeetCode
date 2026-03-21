package simple_tree;

public class LC144 {
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
        //System.out.println("= " + depthRec(tree20));

        /*                     TreeSum = 270

                                    20
                         7                          35
                    4         9               31           40
                     6                     28           38    52
         */
        printTree(tree20);
        // 20 7 4 6 9 35 31 28 40 38 52
    }

    private static void printTree(Tree root) {
        System.out.print(root.value + " ");
        if (root.left != null) {
            printTree(root.left);
        }
        if (root.right != null) {
            printTree(root.right);
        }
    }
}
