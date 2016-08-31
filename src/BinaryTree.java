import java.util.Stack;

/**
 *  BinaryTree.java
 */
public class BinaryTree {

    public Node root;
    private int size;

    public BinaryTree() {
        root = null;
        size = 0;
    }

    public void insert(int data) {
        root = insertNode(root,data);
    }

    private Node insertNode(Node node,int data) {
        if(node == null) {
            return new Node(data);
        } else {
            if(data <= node.data) {
                node.left = insertNode(node.left,data);
            } else {
                node.right = insertNode(node.right,data);
            }
        }
        return node;
    }

    public Node search(int value) {
        return find(root,value);
    }

    private Node find(Node node, int value) {
        if(node == null || node.data == value) {
            return node;
        } else if(value <= node.data) {
            return find(node.left,value);
        } else {
            return find(node.right,value);
        }
    }
    
    public Node findSecondLargest() {
    	if(size() < 2) {
    		throw new IllegalArgumentException("Not enough inputs in the tree!");
    	}
    	
    	Node currentNode = root;
    	
    	while(true) {
    		if(currentNode.left != null && currentNode.right == null) {
    			return maximum();
    		}
    		
    		if(currentNode.right != null && currentNode.right.left == null && currentNode.right.right == null) {
    			return currentNode;
    		}
    		
    		currentNode = currentNode.right;
    	}
    }

    public void preOrderTraversal() {
        performPreOrderTraversal(root);
    }

    public void inOrderTraversal() {
        performInOrderTraversal(root);
    }

    public void postOrderTraversal() {
        performPostOrderTraversal(root);
    }

    public Node minimum() {
        return min(root);
    }

    public Node maximum() {
        return max(root);
    }

    private Node max(Node node) {
        if(node.right == null) {
            return node;
        }
        return max(node.right);
    }

    private Node min(Node node) {
        if(node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public int size() {
        return countNodes(root);
    }

    private int countNodes(Node node) {
        if(node == null) {
            return 0;
        }

        return countNodes(node.left) + 1 + countNodes(node.right);
    }

    private void performPreOrderTraversal(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + " ");
        performPreOrderTraversal(node.left);
        performPreOrderTraversal(node.right);
    }

    private void performInOrderTraversal(Node node) {
        if(node == null) {
            return;
        }
        performInOrderTraversal(node.left);
        System.out.print(node.data + " ");
        performInOrderTraversal(node.right);
    }

    private void performPostOrderTraversal(Node node) {
        if(node == null) {
            return;
        }
        performPostOrderTraversal(node.left);
        performPostOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    /*
     *  Inner class Node
     */
    class Node {
        int data;
        Node left,right;

        public Node(int d){
            data = d;
        }
    }
}
