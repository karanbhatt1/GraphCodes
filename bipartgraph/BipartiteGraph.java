package bipartgraph;

import java.util.HashMap;
import java.util.*;

public class BipartiteGraph {
    /**
     * BipartiteGraph is the graph in which each adjacent node should have different colors;
     * Dividing the graph in two groups;
     *
     * if there is odd cycle then it can't be bipartite;
     * Even cycle graph is also bipartite.
     * A plain graph without cycle will always be bipartite;
     */
    public static boolean bipartite(HashMap<Integer,ArrayList<Integer>> graph , int currnode , int[]color,int currcolor){
        color[currnode] = currcolor;

        for(int neigh : graph.getOrDefault(currnode,new ArrayList<>())){
            if(color[neigh]==color[currnode]){
                return false;
            }
            if(color[neigh] == -1){
                int newcolor = 1-color[currnode];
                if(!bipartite(graph,neigh,color,newcolor)){
                return false;
                }
            }

        }
        return true;
    }
    public static void main(String[] args) {
        // DFS
        //red ==> 1
        // other ==> 0

        // we can do dfs and
//        int V=5;
//        int [] color = new int[V];
//        for(int i =0;i<V;i++){
//            if(color[i]==-1){
//                return bipartite(graph,i,color,1);
//            }
//        }
    }
}
//class Solution {
//    public static boolean bipartite(HashMap<Integer,ArrayList<Integer>> graph, int [] color, int src, int currcol){
//        color[src] = currcol;
//
//        for(int neigh : graph.getOrDefault(src,new ArrayList<>())){
//            if(color[src]==color[neigh]){
//                return false;
//            }
//            if(color[neigh]==-1){
//                int newcolor = 1-color[src];
//                if(!bipartite(graph,color,neigh,newcolor)){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//    public boolean isBipartite(int[][] gr) {
//        int V = gr.length;
//        int cols = gr[0].length;
//        //conversion to graph
//        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
//        int [] color = new int[V];
//
//        for(int node = 0 ;node<V;node++){
//            for(int adj = 0;adj<gr[node].length;adj++){
//                graph.putIfAbsent(node,new ArrayList<>());
//                graph.get(node).add(gr[node][adj]);
//            }
//        }
//
//        // populate color array by -1 and take two color 0 and 1
//        // 1  --> red 0 --> green
//
//        Arrays.fill(color,-1);
//        // normal dfs
//
//        for(int node =0;node<V;node++){
//            if(color[node]==-1 && !bipartite(graph,color,node,1)){
//                return false;
//            }
//        }
//        return true;
//
//    }
//}
