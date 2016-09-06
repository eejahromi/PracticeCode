package iterative;

public class BinarySearchTree {
	private Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public void insert(int value) {
		Node newNode = new Node(value);
		
		if(root == null) {
			root = newNode;
			return;
		}
		
		Node current = root;
		Node parent = null;
		while(true) {
			parent = current;
			
			if(value <= current.data) {
				current = current.left;
				if(current == null) {
					parent.left = newNode;
				}
			} else if(value > current.data) {
				current = current.right;
				if(current == null) {
					parent.right = newNode;
				}
			}
		}
	}
	
	
	
	class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int d) {
			data = d;
		}
	}
}

