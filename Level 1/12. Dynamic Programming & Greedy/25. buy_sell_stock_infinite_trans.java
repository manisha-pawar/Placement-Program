import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        
        int[]prices = new int[n];
        
        for(int i=0;i<n;i++) {
            prices[i] = scn.nextInt();
        }
        
        int ans = infiniteTranscn2(prices);
        
        System.out.println(ans);
    }
    
    public static int infiniteTranscn(int[]prices) {
        int profit = 0;
        
        for(int i=1; i < prices.length;i++) {
            if(prices[i-1] < prices[i]) {
                profit += prices[i] -  prices[i-1];
            }
        }
        
        return profit;
    }
    
    public static int infiniteTranscn2(int[]prices) {
        int op=0;
        int b=0,s=0;
         
         for(int i=0; i < prices.length - 1;i++) {
             if(prices[i] < prices[i+1]) {
                 s = i+1;
             }
             else {
                 op += prices[s] - prices[b];
                 
                 b = i+1;
                 s = i+1;
                 
             }
         }
         
         int cp = prices[s] - prices[b];
         op += cp;
         
         
         return op;
    }

}