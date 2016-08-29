/**
 * Driver.java
 */
public class Driver {
    public static void main(String [] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(6);
        tree.insert(3);

        tree.inOrderTraversal();
        System.out.println();
        System.out.println(tree.size());
    }
}
