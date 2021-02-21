import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        
        int[]coins = new int[n];
        
        for(int i=0;i < coins.length;i++) {
            coins[i]=scn.nextInt();
        }
        
        int amt = scn.nextInt();
        
        int ans = coinChangePerm(coins,amt);
        System.out.println(ans);
    }
    
    public static int coinChangePerm(int[]coins,int amt) {
        
        int[]dp = new int[amt+1];
        
        dp[0] = 1;
        
        for(int i=1; i < dp.length;i++) {
            
            for(int j=0; j < coins.length;j++) {
                int it = i - coins[j];
                
                if(it >= 0) {
                    dp[i] += dp[it];
                }
            }
        }
        
        return dp[amt];
    }
}