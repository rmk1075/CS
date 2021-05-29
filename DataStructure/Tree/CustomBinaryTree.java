package DataStructure.Tree;

public class CustomBinaryTree implements CustomTree {
    Node root;

    public CustomBinaryTree() {
        this.root = null;
    }

    @Override
    public boolean insert(int value) {
        Node newNode = new Node(null, value, null);
        if(this.root == null) {
            this.root = newNode;
            return true;
        }

        Node node = this.root;
        while(node != null) {
            if(node.value == value) {
                return false;
            } else if(node.value < value) {
                if(node.right == null) {
                    node.right = newNode;
                    break;
                }
                node = node.right;
            } else {
                if(node.left == null) {
                    node.left = newNode;
                    break;
                }
                node = node.left;
            }
        }
        return true;
    }

    private void replace(Node parent, Node node) {
        Node target = null;
        if(node.left == null) {
            target = node.right;
        } else if(node.right == null) {
            target = node.left;
        } else {
            // find min leaf of right subtree of node
            target = node.right;
            while(target.left != null) {
                target = target.left;
            }
        }

        if(parent.left == node) {
            parent.left = target;
        } else {
            parent.right = target;
        }
    }

    @Override
    public boolean remove(int value) {
        Node parentNode = null;
        Node node = this.root;
        while(node != null) {
            if(node.value == value) {
                if(parentNode == null) {
                    node = null;
                } else {
                    replace(parentNode, node);
                }
                return true;
            } else if(node.value < value) {
                parentNode = node;
                node = node.right;
            } else {
                parentNode = node;
                node = node.left;
            }
        }
        return false;
    }

    public void preOrder(Node node) {
        System.out.println(node.value);
        if(node.left != null) {
            preOrder(node.left);
        }
        if(node.right != null) {
            preOrder(node.right);
        }
    }

    @Override
    public void preOrder() {
        if(this.root != null) {
            System.out.println("pre");
            preOrder(this.root);
        }
    }

    public void inOrder(Node node) {
        if(node.left != null) {
            inOrder(node.left);
        }
        System.out.println(node.value);
        if(node.right != null) {
            inOrder(node.right);
        }
    }

    @Override
    public void inOrder() {
        if(this.root != null)
            inOrder(this.root);
    }

    public void postOrder(Node node) {
        if(node.left != null) {
            postOrder(node.left);
        }
        if(node.right != null) {
            postOrder(node.right);
        }
        System.out.println(node.value);
    }

    @Override
    public void postOrder() {
        if(this.root != null)
            postOrder(this.root); 
    }
    
}
