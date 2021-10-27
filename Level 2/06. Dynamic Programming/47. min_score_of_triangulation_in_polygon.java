class Solution {
    public int minScoreTriangulation(int[] values) {
       int n = values.length;
        
       int[][]dp = new int[n][n];
        
       for(int d=2; d < n;d++) {
           for(int i = 0,j = d; j < n;i++,j++) {
               if(d == 2) {
                   dp[i][j] = values[i] * values[i+1] * values[i+2];
               }
               else {
                   int min = Integer.MAX_VALUE;
                   
                   for(int k = i+1; k <= j-1;k++) {
                       int la = dp[i][k];
                       int ra = dp[k][j];
                       
                       int sc = values[i] * values[k] * values[j];
                       min = Math.min(min,la + ra + sc);
                   }
                   
                   dp[i][j] = min;
               }
           }
       }
    
       return dp[0][n-1];
    }
}