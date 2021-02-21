import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        
        int[]jumps = new int[n];
        
        for(int i=0;i<n;i++) {
            jumps[i]=scn.nextInt();
        }
        
        //int ans = CSMinMovesMem(0,n,jumps,new int[n+1]);
        
        int tabAns = CSMinMovesTab(jumps);
        
        System.out.println(tabAns);
    }
    
    public static int CSMinMoves(int src,int dest,int[]jumps) {
        if(src == dest) {
            return 0;
        }
        
        int min=Integer.MAX_VALUE;
        for(int step=1; step <= jumps[src] && src + step <= dest;step++) {
            int moves = CSMinMoves(src + step, dest,jumps);
            
            if(moves < min) {
                min = moves;
            }
        }
        
        if(min == Integer.MAX_VALUE) {
            return min;
        }
        
        int ans = min + 1;
        
        return ans;
    }
    
    public static int CSMinMovesMem(int src,int dest,int[]jumps,int[]qb) {
        if(src == dest) {
            return 0;
        }
        
        if(qb[src] != 0) {
            return qb[src];
        }
        
        int min=Integer.MAX_VALUE;
        for(int step=1; step <= jumps[src] && src + step <= dest;step++) {
            int moves = CSMinMovesMem(src + step, dest,jumps,qb);
            
            if(moves < min) {
                min = moves;
            }
        }
        
        if(min == Integer.MAX_VALUE) {
            qb[src] = min;
            return min;
        }
        
        int ans = min + 1;
        qb[src] = ans;
        
        return ans;
    }
    
    public static int CSMinMovesTab(int[]jumps) {
        int n=jumps.length;
        int[]dp = new int[n+1];
        
        //dp[i] -> i to n min moves
        
        dp[n]=0;
        
        for(int i=n-1;i >= 0;i--) {
            
            int min = Integer.MAX_VALUE;
            
            for(int step = 1;step <= jumps[i];step++) {
                int it = i + step; // intermediate
                
                if(it <= n && dp[it] < min) {
                    min = dp[it];
                }
            }
            
            if(min != Integer.MAX_VALUE) {
                dp[i] = min+1;
            }
            else {
                dp[i] = min;
            }
        }
        
        return dp[0];
    }

}