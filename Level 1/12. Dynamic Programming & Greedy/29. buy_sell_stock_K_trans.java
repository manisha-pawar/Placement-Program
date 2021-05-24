import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        
        int[]prices = new int[n];
        
        for(int i=0;i < n;i++) {
            prices[i] = scn.nextInt();
        }
        
        int k=scn.nextInt();
        
        int ans = k_Transcn(prices,k);
        System.out.println(ans);
    }
    
    public static int k_Transcn(int[]prices,int k) {
        int n=prices.length;
        
        int[][]dp = new int[k+1][n];
        
        //dp[i][j] -> upto jth day, i transactions -> max profit
        
        for(int i=0; i < dp.length;i++) {
            for(int j=0;j < dp[0].length;j++) {
                if(i == 0) {
                    //0 transactions
                    dp[i][j] = 0;
                }
                else if(j == 0) {
                    //0th day
                    dp[i][j] = 0;
                }
                else {
                    int max = dp[i][j-1]; // no transaction
                    
                    //single transaction options
                    for(int pd = j-1; pd >= 0; pd--) {
                        int res = prices[j] - prices[pd] + dp[i-1][pd];
                        
                        if(res > max) {
                            max = res;
                        }
                    }
                    
                    dp[i][j] = max;
                }
                
            }
        }
        
        return dp[k][n-1];
    }

}