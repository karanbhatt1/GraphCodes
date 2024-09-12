public class DfsForAdjMatrix {
    public static void dfs(int [][]grid,int r,int c){
        int nr=grid.length;
        int nc = grid[0].length;
        if(r-1>=0 && grid[r-1][c]==1 ){
            dfs(grid,r-1,c);
        }
        if(r+1<nr && grid[r+1][c]==1 ){
            dfs(grid,r+1,c);
        }
        if(c-1>=0 && grid[r][c-1]==1 ){
            dfs(grid,r,c-1);
        }
        if(c+1<nc &&  grid[r][c+1]==1){
            dfs(grid,r,c+1);
        }
    }
    /**
     * THESE CONDTIONS CAN BE APPLIED FOR ALL THE GRAPH ALGORITHMS
     * WE ARE GOING IN 4 DIRECTION FROM THE CURRENT DIRECTION
     * WE ARE GIVEN A BINARY MATRIX (0 INDEXED) OF m*n
     * DFS,BFS,KRUSKAL,BELMENFORD,DIJKASTRA.
     */
}
