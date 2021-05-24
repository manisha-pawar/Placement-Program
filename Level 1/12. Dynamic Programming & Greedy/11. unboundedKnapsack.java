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
        
        int ans = ubKnapsack(val,wt,cap);
        System.out.println(ans);
        
    }
    
    public static int ubKnapsack(int[]val,int[]wt,int cap) {
        int[]dp = new int[cap+1];
        
        dp[0] = 0;
        
        for(int i=1; i <= cap;i++) {
            
            int max = 0;
            
            for(int j=0;j < wt.length;j++) {
                
                int rc = i - wt[j];
                
                if(rc >= 0) {
                    int ans = val[j] + dp[rc];
                    
                    if(ans > max) {
                        max = ans;
                    }
                }
            }
            
            dp[i] = max;
        }
        
        return dp[cap];
    }
}