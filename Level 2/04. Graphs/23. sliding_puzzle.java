//https://leetcode.com/problems/sliding-puzzle/

class Solution {
    public int slidingPuzzle(int[][] board) {
        
        int[][]nbr = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        
        HashSet<String>vis = new HashSet<>();
        
        String src = "";
        String dest = "123450";
        
        for(int i=0; i < board.length;i++) {
            for(int j=0; j < board[0].length;j++) {
                src += board[i][j];
            }
        }
        
        
        //perform bfs
        ArrayDeque<String>q = new ArrayDeque<>();
        q.add(src);
        vis.add(src);
        
        int lev = 0;
        
        while(q.size() > 0) {
            int count = q.size();
            
            while(count-- > 0) {
                //remove
                String rem = q.remove();

                //work
                if(rem.equals(dest) == true) {
                    return lev;
                }

                //add unvisited nbr
                
                //1. find 0's index
                int idx = -1;
                for(int i=0; i < rem.length();i++) {
                    if(rem.charAt(i) == '0') {
                        idx = i;
                        break;
                    }
                }
                
                //2. go to nbr
                for(int i=0; i < nbr[idx].length;i++) {
                    int nbri = nbr[idx][i];
                    
                    //swap
                    String nbrs = findNbrAfterSwapping(rem,idx,nbri);
                    
                    if(vis.contains(nbrs) == false) {
                        q.add(nbrs);
                        vis.add(nbrs);
                    }
                }
                
            }
            
            lev++;
        }
        
        return -1;
        
    }
    
    public String findNbrAfterSwapping(String str,int i,int j) {
        StringBuilder sb = new StringBuilder(str);
        
        char ich = sb.charAt(i);
        char jch = sb.charAt(j);
        
        sb.setCharAt(i,jch);
        sb.setCharAt(j,ich);
        
        return sb.toString();
    } 
    
    
}