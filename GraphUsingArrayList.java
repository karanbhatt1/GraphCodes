import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class GAL{
    int vertices;
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    GAL(int v){
        this.vertices = v;
        for(int i=0;i<=vertices;i++){
            adjList.add(new ArrayList<>());
        }
    }
    public void addEdges(int i,int j) {
        //if (i >= 0 && i <=this.vertices && j >= 0 && j <= this.vertices) {
            adjList.get(i).add(j);
            adjList.get(j).add(i);
        //}
    }
    public void recDFS(int source,int[]vis){
        if(vis[source]==0){
            vis[source]=1;
            System.out.println(source+" ");
            for(int i:adjList.get(source)){
                if(vis[i]==0){
                    recDFS(i,vis);
                }
            }
        }
    }
    public boolean dFS(int source,int col,int[]colour){
        colour[source]=col;
        for(int i:adjList.get(source)){
            if(colour[i]==-1){
                if(!dFS(i,1-col,colour)){return false;}
            } else if(colour[i]==col){ return false;}
        }
        return true;

    }
    public boolean bipartite(int source){
        int[]color = new int[vertices+1];
        Arrays.fill(color,-1);
        for(int i:adjList.get(source)){
            if(color[i]==-1){
                if(!dFS(i,0,color)) return false;
            }
        }return true;

    }

    public void dfs(int source,int[]vis){
        Stack<Integer> st = new Stack<>();
        vis[source]=1;
        st.push(source);
        while(!st.isEmpty()){
            int u = st.pop();
            System.out.println(u+" ");
            for(int adj:adjList.get(u)){
                if(vis[adj]==0){
                    vis[adj]=1;
                    st.push(adj);
                }
            }
        }
    }
    public void display(){
        System.out.println(adjList);
    }
}
public class GraphUsingArrayList {
    public static void main(String[] args) throws IOException {
//        GAL ga = new GAL(4);
//        int[]vis  = new int[5];
//        Arrays.fill(vis,0);
//        ga.addEdges(1,2);
//        ga.addEdges(2,3);
//        ga.addEdges(4,2);
//        ga.addEdges(3,4);
//        ga.addEdges(1,3);
//        ga.recDFS(1,vis);
//        System.out.println(ga.bipartite(1));
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        String s = sc.nextLine();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int b = Integer.parseInt(bf.readLine());
        System.out.println(b);
    }
}
