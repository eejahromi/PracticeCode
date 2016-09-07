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
	
	public Node search(int value) {
		Node current = root;
		
		while(current != null) {
			if(value == current.data) {
				return current;
			} else if(value <= current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		
		return null;
	}
	
	public Node lowestCommonAncestor(int first,int second) {
		Node current = root;
		
		while(current != null) {
			if(first < current.data && second < current.data) {
				current = current.left;
			} else if(first > current.data && second > current.data){
				current = current.right;
			} else {
				break;
			}
		}
		return current;
	}
	
	public boolean validateBST() {
		Stack<NodeBounds> stack = new Stack<NodeBounds>();
		stack.push(new NodeBounds(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
		
		while(!stack.isEmpty()) {
			NodeBounds nb = stack.pop();
			Node current = nb.node;
			int upper = nb.upperbound;
			int lower = nb.lowerbound;
			
			if(current.data < lower || current.data > upper) {
				return false;
			}
			
			if(current.left != null) {
				stack.push(new NodeBounds(current.left,lower,current.data));
			}
			
			if(current.right != null) {
				stack.push(new NodeBounds(current.right,current.data,upper));
			}
		}
		
		return true;
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
	
	class NodeBounds {
		Node node;
		int upperbound;
		int lowerbound;
		
		public NodeBounds(Node n,int lower,int upper) {
			node = n;
			lowerbound = lower;
			upperbound = upper;
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

