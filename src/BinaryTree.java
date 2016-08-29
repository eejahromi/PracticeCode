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

    public void preOrderTraversal() {
        performPreOrderTraversal(root);
    }

    public void inOrderTraversal() {
        performInOrderTraversal(root);
    }

    public void postOrderTraversal() {
        performPostOrderTraversal(root);
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
