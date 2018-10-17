public class Main {

    public static void main(String[] args) {
        RedBlackTree<Integer, Integer> rbt = new RedBlackTree<>();
        rbt.setValue(1, 1);
        rbt.setValue(2, 27);
        rbt.setValue(8, 111);
        rbt.setValue(15, 49);
        rbt.setValue(12, 56);
        
        rbt.printTree(rbt.getRoot());
        System.out.println(rbt.getValue(2));
        rbt.remove(1);
        rbt.printTree(rbt.getRoot());
    }
}
