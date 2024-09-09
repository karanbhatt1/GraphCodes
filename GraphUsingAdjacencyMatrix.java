class GUAM{
    int vertices;
    int[][] am;
    GUAM(int ver){
        this.vertices = ver;
        am = new int[vertices][vertices];
    }
    public void addEdges(int i,int j){
        //for undirected graph;
        if(i>=0&&i<vertices && j>=0 &&j<vertices){
            am[i][j]=1;
            am[j][i]=1;
        }
    }
    public void display(){
        System.out.println("\tA\t\tB\t\tC\t\tD\t\tE");
        char[] labels = {'A', 'B', 'C', 'D', 'E'};
        int k=0;
        for(int[] i:this.am){
            System.out.print(labels[k++]);
            for(int j:i){
                System.out.print("\t"+j+"\t");
            }
            System.out.println();
        }

    }
}
public class GraphUsingAdjacencyMatrix {
    public static void main(String[] args) {
        GUAM graph = new GUAM(5);
        // A<---->B , A<---->C , A<---->D
        graph.addEdges(0,1);
        graph.addEdges(0,2);
        graph.addEdges(0,3);
        //B<---->A,B<---->E
        graph.addEdges(1,0);
        graph.addEdges(1,4);
        //C<---->A ,C<---->D
        graph.addEdges(2,0);
        graph.addEdges(2,3);
        //D<---->A , D<---->E, D<---->C
        graph.addEdges(3,0);
        graph.addEdges(3,2);
        graph.addEdges(3,4);
        //E<---->D,E<---->B
        graph.addEdges(4,3);
        graph.addEdges(4,2);
        graph.display();
    }
}
