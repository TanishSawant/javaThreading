import java.text.MessageFormat;
import java.util.ArrayList;

/**
 * NodeTree
 */
class NodeTree{
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
    NodeTree node;
    ArrayList<Integer> arrayForm = new ArrayList<Integer>();
    binaryTree(int data) {
        this.node = new NodeTree(data);
    }

    synchronized void insert(NodeTree node, int data) {
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
    void getArrayFormOfTree(NodeTree node){
        if (node != null) {
            getArrayFormOfTree(node.leftNode);
            this.arrayForm.add(node.data);
            getArrayFormOfTree(node.rightNode);
        }
    }

    void inOrderTraversal(NodeTree node) {
        if (node != null) {
            inOrderTraversal(node.leftNode);
            System.out.println(node.data);
            inOrderTraversal(node.rightNode);
        }
    }

    int findMin(NodeTree node) {
        if (node == null)
            return Integer.MAX_VALUE;

        int res = node.data;
        int left = findMin(node.leftNode);
        int right = findMin(node.rightNode);

        if (left < res)
            res = left;
        if (right < res)
            res = right;

        return res;
    }

    int findMax(NodeTree node) {
        if (node == null)
            return Integer.MIN_VALUE;

        int res = node.data;
        int left = findMin(node.leftNode);
        int right = findMin(node.rightNode);

        if (left > res)
            res = left;
        if (right > res)
            res = right;

        return res;
    }

    void printLeafNodes(NodeTree root) {
        if (root == null) {
            return;
        }
        if (root.leftNode == null && root.rightNode == null) {
            System.out.println(root.data);
            return;
        }
        if (root.leftNode != null) {
            printLeafNodes(root.leftNode);
        }
        if (root.rightNode != null) {
            printLeafNodes(root.rightNode);
        }
    }

    void printGivenLevel(NodeTree node, int level) {
        if (node == null) {
            return;
        } else if (level == 1) {
            System.out.println(node.data + ' ');
        } else if (level > 1) {
            printGivenLevel(node.leftNode, level - 1);
            printGivenLevel(node.rightNode, level - 1);
        }
    }

    void printLevelOrder(NodeTree node) {
        int h = height(node);
        for (int i = 1; i <= h; i++) {
            printGivenLevel(node, i);
        }
    }

    int height(NodeTree node) {
        if (node == null) {
            return 0;
        } else {
            int ldepth = height(node.leftNode);
            int rdepth = height(node.rightNode);

            if (ldepth > rdepth) {
                return ldepth + 1;
            } else {
                return rdepth + 1;
            }
        }

    }

    NodeTree deleNode(NodeTree root, int x) {
        if (root == null) {
            return root;
        }
        if (root.data < x) {
            root.rightNode = deleNode(root.rightNode, x);
        } else if (root.data > x) {
            root.leftNode = deleNode(root.leftNode, x);
        }

        return root;
    }

    public NodeTree search(NodeTree root, int data) {

        if (root == null || root.data == data)
            return root;

        // val is greater than root's data
        if (root.data > data)
            return search(root.leftNode, data);

        // val is less than root's data
        return search(root.rightNode, data);
    }

    public static void main(String[] args) {
        binaryTree bTree = new binaryTree(10);
        bTree.insert(bTree.node, 5);
        bTree.insert(bTree.node, 1);
        bTree.insert(bTree.node, 0);
        bTree.insert(bTree.node, 22);
        bTree.insert(bTree.node, 12);
        bTree.insert(bTree.node, 54);
        bTree.insert(bTree.node, 32);
        bTree.insert(bTree.node, 56);
        System.out.println("Inorder Traversal :");
        bTree.inOrderTraversal(bTree.node);
        System.out.println(MessageFormat.format("Minimum value node is : {0}", bTree.findMin(bTree.node)));
        System.out.println(MessageFormat.format("Maximum value node is : {0}", bTree.findMax(bTree.node)));
        
        NodeTree searchedNode = bTree.search(bTree.node, 56);
        System.out.println("Node Found!");
    }
}