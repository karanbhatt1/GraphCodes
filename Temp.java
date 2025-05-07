import java.util.ArrayList;
public class Temp {
    private static ArrayList<ArrayList<Integer>> conAmToAL(int[][] adjmat){
        int len=adjmat.length;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=0;i<len;i++){
            al.add(new ArrayList<>());
        }
        for(int i=0;i<adjmat.length;i++){
            for(int j=0;j<adjmat[i].length;j++){
                if(adjmat[i][j]>0){
                    al.get(i).add(adjmat[i][j]);
                }
            }
        }
        return al;
    }

    public static void main(String[] args) {
        int[][] am = {
                {1,2},
                {3},
                {3},
                { }
        };
        ArrayList<ArrayList<Integer>>al = conAmToAL(am);
        System.out.println(al.toString());

    }
}
