import java.util.ArrayList;

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
        tree.insert(7);
    	
    	//initTreeWithPreOrderList(tree);

        tree.inOrderTraversal();
        System.out.println();
        System.out.println(tree.size());
        //System.out.println("Min is " + tree.minimum().data);
        //System.out.println("Max is " + tree.maximum().data);
        //System.out.println("Find " + tree.search(1));
        
        //System.out.println("Find second largest: " + tree.findSecondLargest().data);
        System.out.println(tree.findKLargest(3));
        
    }
    
    private static void initTreeWithPreOrderList(BinaryTree tree) {	
    	ArrayList<Integer> list= new ArrayList<Integer>();
    	list.add(43);
    	list.add(23);
    	list.add(37);
    	list.add(29);
    	list.add(31);
    	list.add(41);
    	list.add(47);
    	list.add(53);
        tree.initWithPreOrderList(list);
    }
}
