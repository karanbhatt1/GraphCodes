package sortestpath;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.*;
public class SingleSortestPath {
    /**
     * BFS,DFS are also single source path algorithm .
     * Modification of BFS is dijkastra which uses priorityqueue.
     * DIJKSTRA --> IT IS ALGORITHM FOR UNDIRECTED OR DIRECTED CONNECTED AND POSTIVIE WEIGHT GRAPH.
     * IT CAN NOT FIND THE PATH ON NEGATIVE WEIGHT EDGE AND DISCONNECTED COMPONENT.
     *>> WE HAVE SOURCE AND DISTANCE ARRAY TO TRACK THE SHORTEST DISTANCE.
     */
}

class Pair implements Comparable<Pair> {
    int node;
    int weight;
    Pair(int ver,int dis){
        this.node = ver;
        this.weight = dis;
    }

    public int compareTo(Pair other){
        return this.weight - other.weight;
    }
}

// User function Template for Java
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        HashMap<Integer,ArrayList<Pair>> graph = new HashMap<>();

        // graph creation with weight;
        for(int []edge : edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            graph.putIfAbsent(u,new ArrayList<Pair>());
            graph.putIfAbsent(v,new ArrayList<Pair>());

            graph.get(u).add(new Pair(v,weight));
            graph.get(v).add(new Pair(u,weight));

        }

        //distance array declaration and intitalization;

        int [] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]= 0;

        // priority queue ==>

        PriorityQueue<Pair> mh = new PriorityQueue<>();
        mh.add(new Pair(src,distance[src]));
// dijkastra algorithm.
        while(!mh.isEmpty()){
            Pair srcw   = mh.poll();
            int u     = srcw.node;
            int weight  = srcw.weight;

            for(Pair neigh:graph.getOrDefault(u,new ArrayList<Pair>())){
                int curnode   = neigh.node;
                int curweight = neigh.weight;

                if(curweight+weight < distance[curnode]){
                    distance[curnode] = curweight+weight;
                    mh.add(new Pair(curnode,distance[curnode]));
                }
            }

        }
        return distance;
        // code here

    }
}
