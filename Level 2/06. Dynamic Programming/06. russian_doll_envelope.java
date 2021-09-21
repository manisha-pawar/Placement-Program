class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        //1. sort on the basis of width
        Arrays.sort(envelopes,(a,b) -> {
            //0th index -> w, 1th index -> height
            if(a[0] == b[0]) {
                return a[1] - b[1];
            } 
            else {
                return a[0] - b[0];
            }
        });
        
        //2. perform lis on the basis of height
        int omax = 0;
        int[]dp = new int[envelopes.length];
        
        for(int i=0; i < envelopes.length;i++) {
            int max = 0;
            
            for(int j=0; j < i;j++) {
                if(envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0]) {
                    max = Math.max(max,dp[j]);
                }
            }
            
            dp[i] = max + 1;
            
            omax = Math.max(dp[i],omax);
        }
        
        return omax;
    }
}