import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        
        int[]val = new int[n];
        
        for(int i=0;i<n;i++) {
            val[i]=scn.nextInt();
        }
        
        int[]wt = new int[n];
        
        for(int i=0;i<n;i++) {
            wt[i]=scn.nextInt();
        }
        
        int cap = scn.nextInt();
        
        int ans = knapsack_01(val,wt,cap);
        
        System.out.println(ans);
    }
    
    public static int knapsack_01(int[]val,int[]wt,int cap) {
        int[][]dp = new int[val.length+1][cap+1];
        
        for(int i=0;i < dp.length;i++) {
            for(int j=0;j < dp[0].length;j++) {
                
                if(i == 0) {
                    // no item
                    dp[i][j] = 0;
                }
                else if(j == 0) {
                    // cap is 0
                    dp[i][j] = 0;
                }
                else {
                    int absent = dp[i-1][j];
                    
                    int present = 0;
                    
                    if(j >= wt[i-1]) {
                        present = val[i-1] + dp[i-1][j-wt[i-1]];
                    }
                    
                    dp[i][j] = Math.max(absent,present);
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length-1]; // dp[val.length][cap]
    }
}