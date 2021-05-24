import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        
        int[]qb=new int[n+1];
        
        int ways = climbStairsTab(n);
        System.out.println(ways);
    }
    
    public static int climbStairs(int src,int n) {
        if(src == n) {
            return 1;    
        }
        
        if(src > n) {
            return 0;    
        }
        
        int a1 = climbStairs(src+1,n);
        int a2 = climbStairs(src+2,n);
        int a3 = climbStairs(src+3,n);
        
        int ans = a1 + a2 + a3;
        
        return ans;
    }
    
    public static int climbStairsMem(int src,int n,int[]qb) {
        if(src == n) {
            return 1;    
        }
        
        if(src > n) {
            return 0;    
        }
        
        if(qb[src] != 0) {
            return qb[src];
        }
        
        int a1 = climbStairsMem(src+1,n,qb);
        int a2 = climbStairsMem(src+2,n,qb);
        int a3 = climbStairsMem(src+3,n,qb);
        
        int ans = a1 + a2 + a3;
        qb[src] = ans;
        
        return ans;
    }
    
    public static int climbStairsTab(int n) {
        int[]dp=new int[n+1];
        
        //dp[i] -> i to n ways
        
        dp[n] = 1;
        
        for(int i = n-1; i >= 0;i--) {
            if(i == n-1) {
                dp[i] = dp[i+1];
            }
            else if(i == n-2) {
                dp[i] = dp[i+1] + dp[i+2];
            }
            else {
                dp[i] = dp[i+1] + dp[i+2] + dp[i+3];
            }
        }
        
        return dp[0];
    }

}