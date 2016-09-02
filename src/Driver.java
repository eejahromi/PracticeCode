
/**
 * Driver.java
 */
public class Driver {
    public static void main(String [] args) {
        //int array[] = {1,3,4,5,7,9,12,23,45};
    	BinaryTree tree = new BinaryTree();
    	//tree.initTreeWithArray(array);
        tree.insert(5);
        tree.insert(3);
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        

        tree.inOrderTraversal();
        System.out.println();
        System.out.println(tree.size());
        //System.out.println("Min is " + tree.minimum().data);
        //System.out.println("Max is " + tree.maximum().data);
        //System.out.println("Find " + tree.search(1));
        
        //System.out.println("Find second largest: " + tree.findSecondLargest().data);
        System.out.print(tree.validateBinarySearchTree());

    }
}
