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

    void printGivenLevel(NodeTree node, int level){
        if (node == null) {
            return;
        }
        else if (level == 1) {
            System.out.println(node.data + ' ');
        }
        else if (level > 1) {
            printGivenLevel(node.leftNode, level-1);
            printGivenLevel(node.rightNode, level-1);
        }
    }

    void printLevelOrder(NodeTree node){
        int h = height(node);
        for (int i = 1; i <= h; i++) {
            printGivenLevel(node, i);
        }
    }

    int height(NodeTree node){
        if (node == null) {
            return 0;
        } else {
            int ldepth = height(node.leftNode);
            int rdepth = height(node.rightNode);

            if(ldepth > rdepth){
                return ldepth + 1;
            }
            else{
                return rdepth + 1;
            }
        }
        
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        binaryTree bTree = new binaryTree(10);
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                bTree.insert(bTree.node, 11);
                bTree.insert(bTree.node, 5);
                bTree.insert(bTree.node, 7);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                bTree.insert(bTree.node, 9);
                bTree.insert(bTree.node, 3);
                bTree.insert(bTree.node, 4);
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                bTree.insert(bTree.node, 16);
                bTree.insert(bTree.node, 12);
                bTree.insert(bTree.node, 13);
                bTree.insert(bTree.node, 1);
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
        bTree.inOrderTraversal(bTree.node);
        long endTime = System.nanoTime();
        long time = endTime-startTime;
        bTree.getArrayFormOfTree(bTree.node);
        System.out.println(bTree.arrayForm);
        System.out.println("Time : " + time);   
    }
}