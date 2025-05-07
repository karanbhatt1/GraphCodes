class Solution {
    private static int dfs(int[][] grid , int r ,int c,int count){
        int nr= grid.length;
        int nc = grid[0].length;
        count++;
        grid[r][c]= 0;

        if((r-1)>=0 && grid[r-1][c]==1){
            count=dfs(grid,r-1,c,count);
        }

        if((r+1)<nr && grid[r+1][c]==1){
            count=dfs(grid,r+1,c,count);

        }

        if((c-1)>=0 && grid[r][c-1]==1){
            count= dfs(grid,r,c-1,count);

        }

        if((c+1)<nc && grid[r][c+1]==1){
            count=dfs(grid,r,c+1,count);

        }
        return count;
    }
    public static  int maxAreaOfIsland(int[][] grid) {
        int max=0;
        int nr = grid.length;
        int nc = grid[0].length;
        int count =0;
        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                if(grid[i][j]==1){

                    count=dfs(grid,i,j,0);
                    max = Math.max(count,max);
                }

            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] grid= { {0, 0, 1, 0,},
                        {0, 0, 0, 0,},
                        {0, 1, 1, 0,},
                        {0, 1, 0, 0,},
                        {0, 1, 0, 0,}
                        };
        maxAreaOfIsland(grid);


    }
}