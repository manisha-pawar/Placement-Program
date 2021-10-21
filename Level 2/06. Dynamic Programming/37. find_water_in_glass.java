//https://practice.geeksforgeeks.org/problems/champagne-overflow2636/1

class Solution {
    static double waterOverflow(int K, int R, int C) {
        double[][]dp = new double[R + 1][R + 1];
        
        dp[0][0] = K;
        
        for(int i=0; i < R;i++) {
            for(int j=0; j <= i;j++) {
                double ew = dp[i][j] - 1; //extra water
                
                if(ew > 0.0) {
                    dp[i][j] = 1.0;
                
                    //equally distribute this extra water in left and right nbr
                    dp[i+1][j] +=  ew / 2; //left nbr
                    dp[i+1][j+1] += ew / 2; //right nbr
                }
            }
        }
        
        //R-1,C-1 because of 1 based indexed ans is expected
        if(dp[R-1][C-1] > 1.0) {
            return 1.0;
        }
        else {
            return dp[R-1][C-1];
        }
    }
}