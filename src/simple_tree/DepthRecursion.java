package simple_tree;

public class DepthRecursion {
    public static void main(String[] args) {
        SimpleTree tree6 = new SimpleTree(6, null, null);
        SimpleTree tree4 = new SimpleTree(4, null, tree6);
        SimpleTree tree9 = new SimpleTree(9, null, null);
        SimpleTree tree7 = new SimpleTree(7, tree4, tree9);

        SimpleTree tree28 = new SimpleTree(28, null, null);
        SimpleTree tree38 = new SimpleTree(38, null, null);
        SimpleTree tree52 = new SimpleTree(52, null, null);
        SimpleTree tree31 = new SimpleTree(31, tree28, null);
        SimpleTree tree40 = new SimpleTree(40, tree38, tree52);
        SimpleTree tree35 = new SimpleTree(35, tree31, tree40);

        SimpleTree tree20 = new SimpleTree(20, tree7, tree35);
        //System.out.println("= " + depthRec(tree20));

        /*                     TreeSum = 270

                                    20
                         7                          35
                    4         9               31           40
                     6                     28           38    52
         */
    }

    /*private static int depthRec(SimpleTree root) {
        //int result = root.value;

        if (root.left != null) {
            return depthRec(root.left);
        }
        if (root.right != null) {
            return depthRec(root.right);
        }
        return root.value;
    }*/
}
