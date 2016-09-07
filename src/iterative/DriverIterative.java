package iterative;

public class DriverIterative {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(8);
		tree.insert(6);
		tree.insert(5);
		tree.insert(7);
		
		tree.inOrderTraversal();
		System.out.println("\n" + tree.search(6));

	}

}
