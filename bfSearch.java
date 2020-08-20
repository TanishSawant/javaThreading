import java.util.LinkedList;
import java.util.Queue;

public class bfSearch {
    private int n;
    private LinkedList<Integer> adjList[];
    private Queue<Integer> q = new LinkedList<>();
    
    public void makeGraph(int no) {
        n = no;
        adjList = new LinkedList[no];
        for (int i = 0; i < no; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    public void addEdge(int u, int v) {
        adjList[u].add(v);
    }
    public void bfTraversal(int V, boolean[] visited) {
        q.add(V);
        visited[V] = true;

        while (!q.isEmpty()) {
            
        }
    }
}