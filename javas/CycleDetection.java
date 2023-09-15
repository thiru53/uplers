package javas;

import java.util.ArrayList;
import java.util.List;

public class CycleDetection {
    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4};
        int[] B = {4, 1, 3, 2};

        System.out.println("IsCycle : " + isCycle(A, B));

        int[] C = {1, 2, 3, 4};
        int[] D = {2, 1, 4, 3};
        System.out.println("C-D : isCycle : "+isCycle(C, D));
    }

    public static boolean isCycle(int[] A, int[] B) {
        int N = A.length;

        Graph graph = new Graph(N);

        for (int i = 0; i < N; i++) {
            graph.addEdge(A[i] - 1, B[i] - 1); // Subtract 1 to convert from 1-based indexing to 0-based indexing
        }

        if (graph.isCycle()) {
            System.out.println("The graph is a cycle.");
        } else {
            System.out.println("The graph is not a cycle.");
        }

        return graph.isCycle();
    }
}

class Graph {
    private int V;
    private List<Integer>[] adjList;

    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to) {
        adjList[from].add(to);
    }

    public boolean isCycle() {
        boolean[] visited = new boolean[V];
        boolean[] stack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCycleUtil(i, visited, stack)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCycleUtil(int v, boolean[] visited, boolean[] stack) {
        visited[v] = true;
        stack[v] = true;

        for (int neighbor : adjList[v]) {
            if (!visited[neighbor]) {
                if (isCycleUtil(neighbor, visited, stack)) {
                    return true;
                }
            } else if (stack[neighbor]) {
                return true;
            }
        }

        stack[v] = false;
        return false;
    }
}

