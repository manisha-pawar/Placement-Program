import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        
        int ans = tiling(n);
        System.out.println(ans);
    }
    
    public static int tiling(int n) {
        int[]dp = new int[n+1];
        
        dp[1] = 1; // 2*1 area
        dp[2] = 2; // 2*2 area
        
        //dp[i] -> no. of ways to tile up 2*i
        
        for(int i = 3; i <= n;i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        
        return dp[n];
    }
}