class Solution {
    
    //0 -> water, 1 -> land
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int i=0; i < grid.length;i++) {
            for(int j=0; j < grid[0].length;j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        
        return count;
    }
    
    static int[][]dir = {{-1,0},{0,-1},{1,0},{0,1}};
    
    public void dfs(int i,int j,char[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        
        for(int[]d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];
            dfs(ni,nj,grid);
        }
    }
}