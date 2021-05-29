package DataStructure.Tree;

public interface CustomTree {
    public class Node {
        int value;
        Node left;
        Node right;

        Node(Node left, int value, Node right) {
            this.left = left;
            this.value = value;
            this.right = right;
        }
    }
        
    boolean insert(int value);
    boolean remove(int value);
    void preOrder();
    void inOrder();
    void postOrder();
}
