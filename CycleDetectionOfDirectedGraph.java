import java.util.*;

public class CycleDetectionOfDirectedGraph {
    // If the graph will have topological sorting then ther is no cycle \
    // else there will be cycle if topological sorting is not possible;
    public static boolean hasCycle(HashMap<Integer, ArrayList<Integer>> graph, Stack<Integer> res, int src, int V) {
        int[] indegree = new int[V];
        Queue<Integer> qu = new LinkedList<>();
        // indegree filling
        for (int u = 0; u < graph.size(); u++) {
            for (int v : graph.getOrDefault(u, new ArrayList<Integer>())) {
                indegree[v] += 1;
            }
        }
        // whose indegree is zero push them to queue;
        for (int u = 0; u < V; u++) {
            if (indegree[u] == 0) {
                qu.add(u);
            }
        }
        // Normal bfs

        while (!qu.isEmpty()) {
            int u = qu.poll();
            for (int v : graph.getOrDefault(u, new ArrayList<>())) {
                if (indegree[v] == 0) {
                    qu.add(v);
                } else {
                    indegree[v] -= 1;
                }
            }
        }
        for(int rc =0;rc<V; rc++){
            if(indegree[rc]>0){
                return true;
            }
        }
        return false;
    }
}