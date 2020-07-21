import java.util.ArrayList;

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
    ArrayList<Integer> arrayForm = new ArrayList<Integer>();
    binaryTree(int data) {
        this.root = new NodeTree(data);
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

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        binaryTree bTree = new binaryTree(10);
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                bTree.insert(bTree.root, 11);
                bTree.insert(bTree.root, 5);
                bTree.insert(bTree.root, 7);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                bTree.insert(bTree.root, 9);
                bTree.insert(bTree.root, 3);
                bTree.insert(bTree.root, 4);
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                bTree.insert(bTree.root, 16);
                bTree.insert(bTree.root, 12);
                bTree.insert(bTree.root, 13);
                bTree.insert(bTree.root, 1);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            t3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        bTree.inOrderTraversal(bTree.root);
        long endTime = System.nanoTime();
        long time = endTime-startTime;
        bTree.getArrayFormOfTree(bTree.root);
        System.out.println(bTree.arrayForm);
        System.out.println("Time : " + time);   
    }
}