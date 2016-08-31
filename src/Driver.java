
/**
 * Driver.java
 */
public class Driver {
    public static void main(String [] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(1);
        tree.insert(10);
        tree.insert(6);
        tree.insert(3);

        tree.inOrderTraversal();
        System.out.println();
        System.out.println(tree.size());
        System.out.println("Min is " + tree.minimum().data);
        System.out.println("Max is " + tree.maximum().data);

    }
}
