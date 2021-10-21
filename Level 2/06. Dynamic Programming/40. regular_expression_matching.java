class Solution {
    public boolean isMatch(String s, String p) {
        
        s = "." + s;
        p = "." + p;
        
        boolean[][]dp = new boolean[p.length()][s.length()];
        
        for(int i=0; i < dp.length;i++) {
            for(int j=0; j < dp[0].length;j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                else if(i == 0) {
                    dp[i][j] = false;
                }
                else if(j == 0) {
                    if(p.charAt(i) == '*') {
                        dp[i][j] = dp[i-2][j];
                    }
                }
                else {
                    if(p.charAt(i) == s.charAt(j) || p.charAt(i)  == '.') {
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else if(p.charAt(i) == '*') {
                        boolean zocc = dp[i-2][j]; //zero occ
                        boolean mt1occ =  (s.charAt(j)  == p.charAt(i-1) || p.charAt(i-1) == '.') ? dp[i][j-1] : false; //more than one occ
                        
                        dp[i][j] = zocc || mt1occ;
                    }
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }
}