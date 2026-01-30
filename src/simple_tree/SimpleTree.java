package simple_tree;

class SimpleTree {
    int value;
    SimpleTree left;
    SimpleTree right;

    public SimpleTree(int value, SimpleTree left, SimpleTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
