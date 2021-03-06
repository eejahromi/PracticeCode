import Sorts.MergeSort;
import Sorts.QuickSort;

import java.util.ArrayList;

/**
 * Driver.java
 */
public class Driver {
    public static void main(String [] args) {

    	BinaryTree tree = new BinaryTree();
    	
        tree.insert(8);
        tree.insert(4);
        tree.insert(1);
        tree.insert(6);
        tree.insert(10);
        tree.insert(14);
        tree.insert(9);
    	
        // Initializing tree with array
        //int array[] = {1,3,4,5,7,9,12,23,45};
        //tree.initTreeWithArray(array);
    	//initTreeWithPreOrderList(tree);

        //tree.inOrderTraversal();
        //tree.printPathToLeaf();
        System.out.println();
        System.out.println(tree.findTreeHeight());
        
        // Tree Min and Max
        //System.out.println("Min is " + tree.minimum().data);
        //System.out.println("Max is " + tree.maximum().data);
        
        // Searching tree for node with value
        //System.out.println("Find " + tree.search(1));
        
        //System.out.println("Find second largest: " + tree.findSecondLargest().data);
        //System.out.println(tree.findKLargest(3));
        //System.out.println(tree.createLevelLinkedList());

        //testSorts();
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

    private static void testSorts() {
        int array[] = {15,4,8,6,25,41,3,1,12};

        int arr[];

        /* MergeSort or QuickSort */

        //arr = MergeSort.mergeSort(array);
        arr = QuickSort.quickSort(array);


        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


}
