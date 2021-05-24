import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int m =scn.nextInt();
        
        int ans = tiling(n,m);
        
        System.out.println(ans);
    }
    
    public static int tiling(int n,int m) {
        int[]dp = new int[n+1];
        
        //m*n total area
        //dp[i] -> no. of ways to tile up m*i area
        
        for(int i=1; i <= n;i++) {
            if(i < m) {
                dp[i] = 1;
            }
            else if(i == m) {
                dp[i] = 2;
            }
            else {
                dp[i] = dp[i-1] + dp[i-m];
            }
        }
        
        return dp[n];
    }
}