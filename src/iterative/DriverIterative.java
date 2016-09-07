package iterative;

public class DriverIterative {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(8);
		tree.insert(6);
		tree.insert(3);
		tree.insert(4);
		tree.insert(7);
		tree.insert(1);
		tree.insert(10);
		
		tree.inOrderTraversal();
		System.out.println("\n" + tree.lowestCommonAncestor(11, 1).data);

	}

}
