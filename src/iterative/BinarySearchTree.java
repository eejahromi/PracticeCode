package iterative;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import org.omg.CORBA.Current;

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
					return;
				}
			} else if(value > current.data) {
				current = current.right;
				if(current == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	public void inOrderTraversal() {
		Stack<Node> stack = new Stack<>();
		Node current = root;
		ArrayList<Integer> list = new ArrayList<>();
		while(!stack.isEmpty() || current != null) {
			if(current != null) {
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				list.add(current.data);
				current = current.right;
			}
		}
		System.out.print(list);
	}
	
	public void preOrderTraversal() {
		Deque<Node> path = new LinkedList<>();
		path.addFirst(root);
		ArrayList<Integer> result = new ArrayList<>();
		while(!path.isEmpty()) {
			Node current = path.removeFirst();
			if(current != null) {
				result.add(current.data);
				path.addFirst(current.right);
				path.addFirst(current.left);
			}
		}
		System.out.print(result);
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

