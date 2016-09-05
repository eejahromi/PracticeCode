import java.util.ArrayList;
import java.util.LinkedList;

/**
 *  BinaryTree.java
 *  A Binary Search Tree class with an inner node class.
 *  All Methods are implemented as instance methods.
 *  All methods in this class are implemented using recursion.
 */
public class BinaryTree {

    public Node root;
    private int rootIndex; 

    public BinaryTree() {
        root = null;
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
    
    public Node initWithPreOrderList(ArrayList<Integer> list) {
    	rootIndex = 0;
    	return root = constructTreeOnValueRange(list,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    private Node constructTreeOnValueRange(ArrayList<Integer> list,Integer lowerBound,Integer upperBound) {
    	if(rootIndex == list.size()) {
    		return null;
    	}
    	
    	Integer root = list.get(rootIndex);
    	if(root < lowerBound || root > upperBound) {
    		return null;
    	}
    	rootIndex++;
    	Node leftSubtree = constructTreeOnValueRange(list,lowerBound,root);
    	Node rightSubtree = constructTreeOnValueRange(list,root,upperBound);
    	
    	Node currentNode = new Node(root);
    	currentNode.left = leftSubtree;
    	currentNode.right = rightSubtree;
    	return currentNode;
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
    	return countBranchNodes(root);
    }

    private int countBranchNodes(Node node) {
		if(node == null) {
			return -1;
		}
		
		return Math.max(countBranchNodes(node.left), countBranchNodes(node.right)) + 1;
	}
    
    public ArrayList<Integer> findKLargest(int k) {
    	if(size() < k) {
    		throw new IllegalArgumentException("Tree is not large enough!");
    	}
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	findLargestNodes(root,k,list);
    	return list;
    }
    
    private void findLargestNodes(Node node,int k,ArrayList<Integer> list) {
    	if(node != null && list.size() < k) {
    		findLargestNodes(node.right,k,list);
    		if(list.size() < k) {
    			list.add(node.data);
    			findLargestNodes(node.left,k,list);
    		}
    	}
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
    
    public ArrayList<LinkedList<Node>> createLevelLinkedList() {
    	ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
    	levelLinkedList(root,lists,0);
    	return lists;
    }
    
    private void levelLinkedList(Node node,ArrayList<LinkedList<Node>> lists,int level) {
    	if(node == null) {
    		return;
    	}
    	
    	LinkedList<Node> list = null;
    	if(lists.size() == level) {
    		list = new LinkedList<Node>();
    		lists.add(list);
    	} else {
    		list = lists.get(level);
    	}
    	list.add(node);
    	levelLinkedList(node.left,lists,level+1);
    	levelLinkedList(node.right,lists,level+1);
    }
    
    public void printEdges() {
    	if(root.left != null) {
    		printLeft(root);
    	}
    	
    	System.out.print(root.data + " ");
    	
    	if(root.right != null) {
    		printRight(root.right);
    	}
    	
    }
    
    private void printLeft(Node node) {
    	if(node == null) {
    		return;
    	}
    	printLeft(node.left);
    	System.out.print(node.data + " ");
    }
    
    private void printRight(Node node) {
    	if(node == null) {
    		return;
    	}
    	System.out.print(node.data + " ");
    	printRight(node.right);
    }
    
    public boolean hasPathSum(int targetSum) {
    	return pathSum(root,0,targetSum);
    }
    
    private boolean pathSum(Node node,int partialSum,int targetSum) {
    	if(node == null) {
    		return false;
    	}
    	
    	partialSum += node.data;
    	if(node.left == null && node.right == null) {
    		return partialSum == targetSum;
    	} 
    	
    	return pathSum(node.left,partialSum,targetSum) || pathSum(node.right,partialSum,targetSum);
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
    
    public boolean isBalanced() {
    	if(checkHeight(root) == -1) {
    		return false;
    	} else {
    		return true;
    	}
    }
    
    private int checkHeight(Node node) {
    	if(node == null) {
    		return 0;
    	}
    	
    	int leftHeight = checkHeight(node.left);
    	if(leftHeight == -1) {
    		return -1;
    	}
    	
    	int rightHeight = checkHeight(node.right);
    	if(rightHeight == -1) {
    		return -1;
    	}
    	
    	int heightDifference = Math.abs(leftHeight - rightHeight);
    	if(heightDifference > 1) {
    		return -1;
    	} else {
    		return Math.max(leftHeight, rightHeight) + 1;
    	}
    }
    
    public boolean isSymmetric() {
    	return root == null || checkSymmetric(root.left,root.right);
    }
    
    private boolean checkSymmetric(Node subtreeOne,Node subtreeTwo) {
    	if(subtreeOne == null && subtreeTwo == null) {
    		return true;
    	} 
    	else if(subtreeOne != null && subtreeTwo != null) {
    		return subtreeOne.data == subtreeTwo.data &&
    				checkSymmetric(subtreeOne.left,subtreeTwo.right) &&
    				checkSymmetric(subtreeOne.right,subtreeTwo.left);
    	}
    	
    	return false;
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
