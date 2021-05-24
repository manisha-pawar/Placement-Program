import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner(System.in);
      
      int n=scn.nextInt();
      int k=scn.nextInt();
      
      long ans = partitionIntoK(n,k);
      System.out.println(ans);
   }
   
   public static long partitionIntoK(int n,int k) {
       long[][]dp = new long[n+1][k+1];
       
       for(int p=0;p < dp.length;p++) {
           for(int s=0;s < dp[0].length;s++) {
               if(s == 0 || p == 0) {
                   dp[p][s] = 0;
               }
               else if(p < s) {
                   dp[p][s] = 0;
               }
               else if(p == s || s == 1) {
                   dp[p][s] = 1;
               }
               else {
                   dp[p][s] = dp[p-1][s] * s + dp[p-1][s-1];
               }
           }
       }
       
       return dp[n][k];
   }
}