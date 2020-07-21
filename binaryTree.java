/**
 * NodeTree
 */
class NodeTree {
    int data;
    NodeTree leftNode;
    NodeTree rightNode;
    public NodeTree(int data) {
        this.data = data;
        this.rightNode = null;
        this.leftNode = null;
    }
}

public class binaryTree {
    NodeTree root;
    binaryTree(int data) {
        this.root = new NodeTree(data);
    }
    void insert(NodeTree node, int data){
        if (data < node.data) {
            if (node.leftNode != null) {
                insert(node.leftNode, data);
            } else {
                System.out.println("Appended node on the left of " + node.data);
                node.leftNode = new NodeTree(data);
            }
        } else {
            if (data > node.data) {
                if (node.rightNode != null) {
                    insert(node.rightNode, data);
                } else {
                    System.out.println("Appended node on the right of " + node.data);
                    node.rightNode = new NodeTree(data);
                }
            }
        }
    }
    void inOrderTraversal(NodeTree node){
        if(node != null){
            inOrderTraversal(node.leftNode);
            System.out.println(node.data);
            inOrderTraversal(node.rightNode);
        }
    }
    public static void main(String[] args) {
     binaryTree bTree = new binaryTree(10);
     bTree.insert(bTree.root, 11);   
     bTree.insert(bTree.root, 13);   
     bTree.insert(bTree.root, 1);   
     bTree.insert(bTree.root, 5);   
     bTree.insert(bTree.root, 7);   
     bTree.insert(bTree.root, 9);   
     bTree.insert(bTree.root, 3);   
     bTree.insert(bTree.root, 16);   
     bTree.insert(bTree.root, 12);   
     bTree.insert(bTree.root, 4);
     bTree.inOrderTraversal(bTree.root);   
    }
}