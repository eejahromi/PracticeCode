/**
 *  BinaryTree.java
 *  A Binary Search Tree class with an inner node class.
 *  All Methods are implemented as instance methods.
 *  All methods in this class are implemented using recursion.
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
    
    public void initTreeWithArray(int array[]) {
    	if(array == null || array.length == 0) {
    		throw new IllegalArgumentException("Invalid input!");
    	}
    	
    	root = insertArray(array,0,array.length-1);
    }
    
    public Node insertArray(int array[],int lower,int upper) {
    	if(lower > upper) {
    		return null;
    	}
    	int mid = (upper + lower)/2;
    	Node currentNode = new Node(array[mid]);
    	
    	currentNode.left = insertArray(array,lower,mid-1);
    	currentNode.right = insertArray(array,mid+1,upper);
    	
    	return currentNode;
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
    
    public Node findLowestCommonAncestor(int value1,int value2) {
    	return findCommonAncestor(root,value1,value2);
    }
    
    private Node findCommonAncestor(Node node,int value1,int value2) {
    	if(value1 < node.data && value2 < node.data) {
    		return findCommonAncestor(node.left,value1,value2);
    	} else if (value1 > node.data && value2 > node.data) {
    		return findCommonAncestor(node.right,value1,value2);
    	} else {
    		return node;
    	}
    }
    
    public int findTreeHeight() {
    	return countLeafs(root);
    }

    private int countLeafs(Node node) {
		if(node == null) {
			return -1;
		}
		
		return Math.max(countLeafs(node.left), countLeafs(node.right)) + 1;
	}
    
    public boolean validateBinarySearchTree() {
    	return validate(root,null,null);
    }
    
    private boolean validate(Node node,Integer min,Integer max) {
    	if(node == null) {
    		return true;
    	}
    	
    	if((max != null && node.data > max) || (min != null && node.data <= min)) {
    		return false;
    	} 
    	
    	if(!validate(node.left,min,node.data) || !validate(node.right,node.data,max)) {
    		return false;
    	}
    	
    	return true;
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
