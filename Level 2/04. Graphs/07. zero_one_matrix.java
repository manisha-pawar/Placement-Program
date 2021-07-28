class Solution {
    
    static class Pair {
        int i;
        int j;
        
        Pair(int i,int j) {
            this.i = i;
            this.j = j;
        }
        
        Pair() {
            
        }
    }
    
    
    public int[][] updateMatrix(int[][] mat) {
        
        ArrayDeque<Pair>q = new ArrayDeque<>();
        
        for(int i=0; i < mat.length;i++) {
            for(int j=0; j < mat[0].length;j++) {
                if(mat[i][j] == 0) {
                    q.add(new Pair(i,j));
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }
        
        int[][]dir = {{-1,0},{0,-1},{1,0},{0,1}};
        
        while(q.size() > 0) {
            
            //remove
            Pair rem = q.remove();
            int ri = rem.i;
            int rj = rem.j;
            
            //add nbr
            for(int i=0; i < 4;i++) {
                int ni = ri + dir[i][0];
                int nj = rj + dir[i][1];
                
                if(ni >= 0 && ni < mat.length && nj >= 0 && nj < mat[0].length && mat[ni][nj] == -1) {
                    mat[ni][nj]  = mat[ri][rj] + 1;
                    q.add(new Pair(ni,nj));
                }
            }
        }
        
        return mat;
    
    }
}