public class Solution {
    
    static String sc; //single component

    public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        HashSet<String>hs = new HashSet<>();

        for(int i=0; i < grid.length;i++) {
            for(int j=0; j < grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    sc = ".";
                    dfs(i,j,grid);
                    hs.add(sc);
                }
            }
        }

        return hs.size();
    }

    public void dfs(int i,int j,int[][]grid) {

        grid[i][j] = 0;

        if(i-1 >= 0 && grid[i-1][j] == 1) {
            sc += "t";
            dfs(i-1,j,grid);
        }

        if(j-1 >= 0 && grid[i][j-1] == 1) {
            sc += "l";
            dfs(i,j-1,grid);
        }

        if(i+1 < grid.length && grid[i+1][j] == 1) {
            sc += "d";
            dfs(i+1,j,grid);
        }

        if(j+1 < grid[0].length && grid[i][j+1] == 1) {
            sc += "r";
            dfs(i,j+1,grid);
        }

        sc += "z";


    }

}