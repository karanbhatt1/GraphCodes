import java.util.*;

public class TopologicalSort {

    /*
    TOPOLOGICAL SORT USING DFS;
    SORTING CAN BE APPLIED ONLY IN DIRECTED ACYCLIC GRAPH
    */
    public static void ts(HashMap<Integer, ArrayList<Integer>> graph, Stack<Integer> res,boolean[]vis,int src){
        vis[src] = true;
        for(int neigh : graph.getOrDefault(src,new ArrayList<>())){
            if(!vis[neigh]){
                ts(graph,res,vis,neigh);
            }
        }
        res.add(src);
    }

    // TOPOLOGICAL SORTING USING BFS (IT IS ALSO CALLED KAHN'S ALGORITHM

    // iNDEGREE --> INSERT ALL THE VERTEX HAVING 0 INDEGREE;
    // We can take an array of indegree

    public static void bfsts(HashMap<Integer,ArrayList<Integer>> graph, Stack<Integer> res , int src,int V){
        int[] indegree = new int[V];
        Queue<Integer> qu = new LinkedList<>();
        // indegree filling
        for(int u= 0;u<graph.size();u++){
            for(int v: graph.getOrDefault(u,new ArrayList<Integer> ())){
                indegree[v]+=1;
            }
        }
        // whose indegree is zero push them to queue;
        for(int u=0;u<V;u++){
            if(indegree[u]==0){
                qu.add(u);
            }
        }
        // Normal bfs

        while(!qu.isEmpty()){
            int u = qu.poll();
            res.push(u);
            for(int v : graph.getOrDefault(u,new ArrayList<>())){
                if(indegree[v]==0){
                    qu.add(v);
                }else{
                    indegree[v] -=1;
                }
            }
        }

    }


}
