import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        
        int[][]cost = new int[n][m];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                cost[i][j]=scn.nextInt();
            }
        }
        
        //int ans = mazeMinCostMem(0,0,cost,new int[n][m]);
        
        int tabAns = mazeMinCostTab(cost);
        System.out.println(tabAns);
    }
    
    public static int mazeMinCost(int sr,int sc,int[][]cost) {
        if(sr == cost.length - 1 && sc == cost[0].length-1) {
            return cost[sr][sc];
        }
     
        int c1 = Integer.MAX_VALUE; // horizontal nbr to dest min cost
        int c2 = Integer.MAX_VALUE; // vertical nbr to dest min cost
        
        if(sc + 1 < cost[0].length) {
            c1 = mazeMinCost(sr,sc+1,cost);
        }
        
        if(sr + 1 < cost.length) {
            c2 = mazeMinCost(sr+1,sc,cost);
        }
        
        int ans = Math.min(c1,c2) + cost[sr][sc];
        
        return ans;
    }
    
    public static int mazeMinCostMem(int sr,int sc,int[][]cost,int[][]qb) {
        if(sr == cost.length - 1 && sc == cost[0].length-1) {
            return cost[sr][sc];
        }
        
        if(qb[sr][sc] != 0) {
            return qb[sr][sc];    
        }
        
        int c1 = Integer.MAX_VALUE; // horizontal nbr to dest min cost
        int c2 = Integer.MAX_VALUE; // vertical nbr to dest min cost
        
        if(sc + 1 < cost[0].length) {
            c1 = mazeMinCostMem(sr,sc+1,cost,qb);
        }
        
        if(sr + 1 < cost.length) {
            c2 = mazeMinCostMem(sr+1,sc,cost,qb);
        }
        
        int ans = Math.min(c1,c2) + cost[sr][sc];
        qb[sr][sc] = ans;
        
        return ans;
    }
    
    public static int mazeMinCostTab(int[][]cost) {
        int n=cost.length;
        int m=cost[0].length;
        
        int[][]dp = new int[cost.length][cost[0].length];
        
        //dp[i][j] -> i,j to dest min cost
        
        for(int i=n-1; i >= 0 ;i--) {
            for(int j=m-1;j >= 0;j--) {
                if(i == n-1 && j == m-1) {
                    dp[i][j] = cost[i][j];
                }
                else if(i == n-1) {
                    dp[i][j] = dp[i][j+1] + cost[i][j];
                }
                else if(j == m-1) {
                    dp[i][j] = dp[i+1][j] + cost[i][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i][j+1] , dp[i+1][j]) + cost[i][j];
                }
            }
        }
        
        return dp[0][0];
        
        
    }

}