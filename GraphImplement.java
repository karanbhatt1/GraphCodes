import java.security.KeyPair;
import java.util.*;

class Graph{
    int[][] adjacencymatrix;
    int[] visited;
    Stack<Integer> st;
    int numVertices;
    Graph(int numVertices){

        this.numVertices=numVertices;
        adjacencymatrix= new int[numVertices+1][numVertices+1];
        visited = new int[numVertices+1];
        for(int i= 0;i<=this.numVertices;i++){
            visited[i]=0;
        }
        st = new Stack<>();
    }
    private boolean dFS(int s,int col,int[]color,int[][]adj){
        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        color[s]=col;
        for(int i=0;i<this.numVertices;i++){
            ar.add(new ArrayList<>());
        }
        for(int i=0;i<this.numVertices;i++){
            for(int j=0;j<this.numVertices;j++){
                if(adj[i][j]!=0){
                    ar.get(i).add(j);
                }
            }
        }
        for(int it:ar.get(s)){
            if(color[it]==-1){
                if(dFS(it,1-col,color,adj)==false) return false;
                else if (color[it]==col){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bipartite(int[][]adj){
        int[] color = new int[this.numVertices+1];
        for(int i=0;i<this.numVertices;i++){
            if(color[i]==-1){
                if(dFS(i,0,color,adj)==false) return false;
            }
        } return true;

    }
    public boolean detectCycle(int [][]arr,int source,int []vis){
        Queue<Integer> qe = new LinkedList<>();
        int []parent = new int[this.numVertices+1];
        Arrays.fill(parent,0);
        Arrays.fill(vis,0);
        vis[source]=1;
        parent[source]=-1;
        qe.add(source);
        while(!qe.isEmpty()){
            int u = qe.remove();
            for(int i=1;i<arr.length;i++){
                if(arr[u][i]==1&&vis[i]==0){
                    vis[i]=1;
                    parent[i]=u;
                    qe.add(i);
                }else if(arr[u][i]==1&&parent[i]!=0&&vis[i]==1){
                    return true;
                }
            }
        }return false;

    }
    public void dfs(int u){
        if(visited[u]==0){
            System.out.print(u+" ");
            visited[u]=1;
            for(int v = 1;v<=this.numVertices;v++){
                if(adjacencymatrix[u][v]==1 && visited[v]==0){
                    dfs(v);
                    System.out.println();
                }
            }
        }

    }
    public boolean detectCycledfs(int[][] adjacencyMatrix, int source,int[]vis) {
        vis[source] = 1; // Mark source as visited
        st.push(source);      // Push source to stack

        while (!st.isEmpty()) {
            int u = st.pop();
            for (int v = 1; v < this.numVertices; v++) {
                if (adjacencyMatrix[u][v] == 1) {
                    if (vis[v] == 0) { // Unvisited neighbor, explore further
                        vis[v] = 1;
                        st.push(v);
                    } else {
                        // Check if v is already visited and not in current path
                        boolean isCycle = false;
                        for (int element : st) {
                            if (element == v) {
                                isCycle = true;
                                break;
                            }
                        }
                        if (isCycle) {
                            return true; // Cycle found
                        }
                    }
                }
            }
        }

        return false; // No cycle found
    }


    public void addEdge(int i,int j){
        //if(i>=0&& i<=numVertices && j>=0 && j<=numVertices){
            adjacencymatrix[i][j]=1;
            //adjacencymatrix[j][i]=1;
        //}
    }
    public void removeEdge(int i, int j){
        if(i>=0 && i<=numVertices && j>=0 && j<=numVertices){
            adjacencymatrix[i][j]=0;
            adjacencymatrix[i][j]=0;
        }
    }
    public void  display(){
        for(int i=1;i<adjacencymatrix.length;i++){
            for(int j=1;j<adjacencymatrix.length;j++){
                System.out.print(adjacencymatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


public class  GraphImplement {
    public static void main(String[] args) {
        //System.out.println("enter total no of vertices::");
        //Scanner sc = new Scanner(System.in);
        //int vertex = sc.nextInt();
        Graph g = new Graph(6);
        int[] v= new int[7];
        int []color = new int[7];
        Arrays.fill(color,-1);
        Arrays.fill(v,0);
        g.addEdge(1,2);
        g.addEdge(2,6);
        g.addEdge(1,3);
        g.addEdge(3,5);
        g.addEdge(5,6);
        g.addEdge(6,4);
        System.out.println(g.bipartite(g.adjacencymatrix));
        // int e1,e2;
        //for (int j=0;j<vertex;j++) {
        //    System.out.println("enter the total edges you want for vertex"+(j+1));
        //    int edge = sc.nextInt();
        //    for (int i = 0; i < edge; i++) {
        //        System.out.println("enter the edges you want for vertex"+(j+1));
        //        e1 = sc.nextInt();
        //        e2 = sc.nextInt();
        //        g.addEdge(e1, e2);
        //    }
        //}
        //System.out.println("enter the vertex from where you want dfs traversal::");
        //int so = sc.nextInt();
        System.out.println("here is the dfs traversal:");
        g.dfs(1);
        g.display();
        System.out.println(g.detectCycle(g.adjacencymatrix,1,v));
;    }
}
