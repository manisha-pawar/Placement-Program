class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][]dp = new int[n][n];
        
        for(int d=0; d < n;d++) {
            for(int i=0, j = d; j < n;i++,j++) {
                if(d == 0) {
                    int lv = (i == 0) ? 1 : nums[i-1];
                    int rv = (i + 1 == n) ? 1 : nums[i+1];
                    dp[i][j] = lv * nums[i] * rv;
                }
                else {
                    int max = Integer.MIN_VALUE;
                    
                    for(int k = i; k <= j;k++) {
                        int la = (k == 0) ? 0 : dp[i][k-1];  //left part ans
                        int ra = (k + 1 == n) ? 0 : dp[k+1][j]; //right part ans

                        int lv = (i == 0) ? 1 : nums[i-1];
                        int rv = (j + 1 == n) ? 1 : nums[j+1];
                        int sc = lv * nums[k] * rv;
                        
                        max = Math.max(max, la + ra + sc);
                    }
                    
                    dp[i][j] = max;
                }
            }
        }
        return dp[0][n-1];
    }
}