class Solution {
    public int nthUglyNumber(int n) {
        
        int[]dp = new int[n+1];
        
        dp[1] = 1; //1st ugly number
        
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        
        for(int i=2; i <= n;i++) {
            int c2 = 2 * dp[p2];
            int c3 = 3 * dp[p3];
            int c5 = 5 * dp[p5];
            
            int un = Math.min(Math.min(c2,c3),c5);
            dp[i] = un;
            
            if(un == c2) {
                p2++;
            }
            if(un == c3) {
                p3++;
            }
            if(un == c5) {
                p5++;
            }
        }
        
        return dp[n];
    }
}