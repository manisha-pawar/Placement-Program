class Solution {
    
    static class Pair {
        int i;
        int j;
        
        Pair() {
            
        }
        
        Pair(int i,int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        ArrayDeque<Pair>q = new ArrayDeque<>();
        int fo = 0;
        
        for(int i=0; i < grid.length;i++) {
            for(int j=0; j < grid[0].length;j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i,j));
                }
                else if(grid[i][j] == 1) {
                    fo++;
                }
            }
        }
        
        if(fo == 0) {
            return 0;
        }
        
        int lev = 0;
        
        while(q.size() > 0) {
            int count = q.size();
            
            if(fo == 0) {
                return lev-1;
            }
            
            while(count-- > 0) {
                //remove
                Pair rem = q.remove();
                
                //mark
                if(lev != 0 && grid[rem.i][rem.j] == 2) {
                    continue;
                }
                
                if(grid[rem.i][rem.j] == 1) {
                    fo--;
                }
                
                grid[rem.i][rem.j] = 2;
                
                
                //add nbr
                int ri = rem.i;
                int rj = rem.j;
                
                if(ri - 1 >= 0 && grid[ri-1][rj] == 1) {
                    q.add(new Pair(ri-1,rj));
                }
                
                if(rj - 1 >= 0 && grid[ri][rj-1] == 1) {
                     q.add(new Pair(ri,rj-1));
                }
                
                if(ri + 1 < grid.length && grid[ri+1][rj] == 1) {
                     q.add(new Pair(ri+1,rj));
                }
                
                if(rj + 1 < grid[0].length && grid[ri][rj+1] == 1) {
                     q.add(new Pair(ri,rj+1));
                }
            }
            
            lev++;
            
        }
        
        
        if(fo == 0) {
            return lev-1;
        }
        else {
            return -1;
        }
       
    }
     
}