import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[]jumps = new int[n];
        
        for(int i=0;i < n;i++) {
            jumps[i]=scn.nextInt();
        }
        
        int[]qb = new int[n+1];
        
        int ans = CSVJMem(0,n,jumps,qb);
        System.out.println(ans);
    }
    
    public static int CSVJMem(int src,int n,int[]jumps,int[]qb) {
        if(src == n) {
            return 1;
        }
        
        if(qb[src] != 0) {
            return qb[src];
        }
    
        int ans=0;
        for(int step = 1 ; step <= jumps[src] && src + step <= n;step++) {
            ans = ans + CSVJMem(src + step, n ,jumps,qb);
        }
        qb[src] = ans;
        return ans;
    }
    
    
    public static int CSVJTab(int[]jumps) {
        int n = jumps.length;
        int[]dp = new int[n+1];
        
        //dp[i] -> i to n
        dp[n] = 1;
        
        for(int i=n-1; i >= 0;i--) {
            int ans = 0;
            for(int step = 1; step <= jumps[i] && i + step <= n; step++) {
                ans = ans + dp[i + step];
            }
            dp[i]=ans;
        }
        
        return dp[0];
    }

}