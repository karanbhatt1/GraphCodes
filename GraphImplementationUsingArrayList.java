import java.util.ArrayList;
class GUAL{
    int vertices;
    ArrayList<ArrayList<Integer>> al;
    GUAL(int vertex){
        this.vertices = vertex;
        al = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<vertices;i++){
            al.add(i,new ArrayList<Integer>());
        }
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
}
public class GraphImplementationUsingArrayList {
    public static void main(String[] args) {
        GUAL graph = new GUAL(5);
        graph.addEdges(0,1);
        graph.addEdges(0,3);
        graph.addEdges(0,2);
        graph.addEdges(1,4);
        graph.addEdges(4,3);
        graph.addEdges(3,2);
        graph.display();

    }
}
