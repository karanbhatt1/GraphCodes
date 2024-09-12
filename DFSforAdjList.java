import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class GR {
    int vertices;
    ArrayList<ArrayList<Integer>> al;
    boolean [] visited;
    int [] parent;
    GR(int vertex){
        this.vertices = vertex;
        al = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<vertices;i++){
            al.add(i,new ArrayList<Integer>());
        }
        visited= new boolean[vertex];
        Arrays.fill(visited,false);
        parent = new int[vertex];
        Arrays.fill(parent,-1);
    }
    public void addEdges(int i,int j){
        al.get(i).add(j);
        al.get(j).add(i);
    }
    public void display(){
        for(int i=0;i<al.size();i++){
            System.out.println("\nvertex:"+i);
            System.out.println("\t --> path from "+i+"\tto\n");
            for(int j=0;j<al.get(i).size();j++){
                System.out.print("\t"+al.get(i).get(j));
            }
            System.out.println();
        }
    }
    public void dfs(int u,boolean[] vis){
        visited[u]=true;
        System.out.print(u+"\t");
        for(int i:al.get(u)){
                if(!visited[i]){
                   dfs(i,visited);
                }
        }
    }
}

public class DFSforAdjList{

    public static void main(String[] args) {
        GR graph = new GR(5);
        graph.addEdges(0,1);
        graph.addEdges(0,3);
        graph.addEdges(0,2);
        graph.addEdges(1,4);
        graph.addEdges(4,3);
        graph.addEdges(3,2);
        graph.display();
        graph.dfs(0,graph.visited);

    }
}
