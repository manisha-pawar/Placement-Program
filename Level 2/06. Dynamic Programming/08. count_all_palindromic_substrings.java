class Solution {
    public int countSubstrings(String s) {
        
        int n = s.length();
        boolean[][]dp = new boolean[n][n];
        int count = 0;
        
        
        for(int d = 0; d < n;d++) {
            for(int i = 0,j = d; j < n; i++,j++) {
                if(d == 0) {
                    //one length substrings
                    dp[i][j] = true;
                }
                else if(d == 1) {
                    //two length substrings
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = false;
                    }
                }
                else {
                    //substring with length > 2
                    dp[i][j] =  s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }
                
                if(dp[i][j] == true) {
                    count++;
                }
            }
        }
        return count;
    }
}