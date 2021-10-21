class Solution {
    public int minDistance(String word1, String word2) {
        int[][]dp = new int[word1.length()+1][word2.length()+1];
        
        for(int i=dp.length-1; i >= 0;i--) {
            for(int j = dp[0].length-1; j >= 0;j--) {
                if(i == dp.length-1 && j == dp[0].length-1) {
                    dp[i][j] = 0;
                }
                else if(i == dp.length-1) {
                    dp[i][j] = dp[i][j+1] + 1;
                }
                else if(j == dp[0].length-1) {
                    dp[i][j] = dp[i+1][j] + 1;
                }
                else {
                    if(word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = dp[i+1][j+1];
                    }
                    else {
                        int cr = dp[i+1][j+1]; //char replacement
                        int cd = dp[i+1][j]; //char deletion
                        int ca = dp[i][j+1]; //char addition
                        
                        dp[i][j] = Math.min(Math.min(cr,cd),ca) + 1;
                    }
                }
            }
        }
        return dp[0][0];
    }
}