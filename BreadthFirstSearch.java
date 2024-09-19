import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    private static ArrayList<ArrayList<Integer>> conAmToAL(int[][] adjmat){
        int rows =adjmat.length;
        int columns = adjmat[0].length;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=0;i<rows;i++){
            al.add(new ArrayList<>());
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(adjmat[i][j]==1) {
                    al.get(i).add(j);
                }
            }
        }
        return al;
    }
    private static void BFS(int[][]grid, int u){
        ArrayList<ArrayList<Integer>> al = conAmToAL(grid);
        Queue<Integer> q = new LinkedList<>();
        int size = al.size();
        boolean[]vis = new boolean[size];
        Arrays.fill(vis,false);
        vis[u]=true;
        q.add(u);

        System.out.print(u);
        while(!q.isEmpty()){
            int v = q.remove();
            for(int i: al.get(v)){
                if(!vis[i]){
                    vis[i]=true;
                    System.out.print("\t"+i);
                    q.add(i);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] grid= { {0, 0, 1, 0,1},
                        {0, 0, 1, 1,1},
                        {1, 1, 1, 0,1},
                        {0, 1, 0, 0,1},
                        {1, 1, 1, 1,1}
        };
       BFS(grid,0);
        ArrayList<ArrayList<Integer>> al = conAmToAL(grid);
        System.out.println(al);

    }
}
