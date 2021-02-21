import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        
        int[][]mat = new int[n][m];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                mat[i][j] = scn.nextInt();
            }
        }
        
        int ans = 0;
        int[][]qb = new int[n][m];
        
        // for(int i=0; i < n;i++) {
        //     int cost = goldmine(i,0,mat,qb);
            
        //     if(ans < cost) {
        //         ans = cost;
        //     }
            
        // }
        
        int tabAns = goldmineTab(mat);
        
        System.out.println(tabAns);
    }
    
    public static int goldmine(int i,int j,int[][]mat,int[][]qb) {
        if(j >= mat[0].length || i < 0 || i >= mat.length) {
            return 0;
        }
        
        if(qb[i][j] != 0) {
            return qb[i][j];
        }
        
        int i1 = goldmine(i-1,j+1,mat,qb);
        int i2 = goldmine(i,j+1,mat,qb);
        int i3 = goldmine(i+1,j+1,mat,qb);
        
        int ans = mat[i][j] + Math.max(i3,Math.max(i1,i2));
        qb[i][j] = ans;
        
        return ans;
    }
    
    public static int goldmineTab(int[][]mat) {
        
        int n=mat.length;
        int m=mat[0].length;
        
        int[][]dp = new int[n][m];
        //dp[i][j] -> starting from i,j till last col max gold collected
        
        for(int j=m-1; j >= 0;j--) {
            for(int i=0;i < n;i++) {
                
                if(j == m-1) {
                    dp[i][j] = mat[i][j];
                }
                else if(i == 0) {
                    dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j+1]) + mat[i][j];
                }
                else if(i == n-1) {
                     dp[i][j] = Math.max(dp[i-1][j+1],dp[i][j+1]) + mat[i][j];
                }
                else {
                     dp[i][j] = Math.max(dp[i-1][j+1],Math.max(dp[i][j+1],dp[i+1][j+1])) + mat[i][j];
                }
            }
        }
        
        //max of first col
        int ans = 0;
        
        for(int i=0;i < n;i++) {
            if(dp[i][0] > ans) {
                ans = dp[i][0];
            }
        }
        
        return ans;
        
        
    }

}