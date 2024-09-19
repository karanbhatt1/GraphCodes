import java.util.ArrayList;
class GUM{
    int vertices;
    int[][] am;
    GUM(int ver){
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

public class ConversionOfAdjMatrixToAdjList {
    private static ArrayList<ArrayList<Integer>> conAmToAL(int[][] adjmat,int vertex){
        int len=adjmat.length;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=0;i<vertex;i++){
            al.add(new ArrayList<>());
        }
        for(int i=0;i<vertex;i++){
            for(int j=0;j<vertex;j++){
                if(adjmat[i][j]==1) {
                    al.get(i).add(j);
                }
            }
        }
        return al;
    }
    private static void displayAdjlist(ArrayList<ArrayList<Integer>> al){
        for(int i=0;i<al.size();i++){
            System.out.print("\nVERTEX:\t"+i);
            System.out.println("\n\tPATH FROM VERTEX "+i+" TO\n\t");
            for(int j=0;j<al.get(i).size();j++){
                System.out.print("\t-->\t"+al.get(i).get(j));
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        GUM graph = new GUM(5);
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
        graph.addEdges(4,1);
        graph.display();
        ArrayList<ArrayList<Integer>> al = conAmToAL(graph.am,5);
        displayAdjlist(al);
    }
}
