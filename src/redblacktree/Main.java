package redblacktree;

public class Main {

    public static void main(String[] args) {
        RedBlackTree<String, String> tree = new RedBlackTree<>();
        tree.setValue("A", "A");
        tree.setValue("L", "L");
        tree.setValue("G", "G");
        tree.setValue("O", "O");
        tree.setValue("R", "R");
        tree.setValue("Y", "Y");
        tree.setValue("T", "T");
        tree.setValue("M", "M");

        tree.printTree(tree.getRoot());

        OperationsTiming timing = new OperationsTiming();
        timing.measureOperationsTime(550, 1000000);
    }
}
