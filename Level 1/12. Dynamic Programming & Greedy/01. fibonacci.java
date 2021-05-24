import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    
    int[]qb=new int[n+1];
    
    int ans=fibTabulated(n);
    
    System.out.println(ans);
 }
 
 
 public static int fib(int n) {
     if(n == 0 || n == 1) {
         return n;
     }
     
     int fibn = fib(n-1) + fib(n-2);
     
     return fibn;
 }
 
 public static int fibMemoised(int n,int[]qb) {
     if(n == 0 || n == 1) {
         return n;
     }
     
     if(qb[n] != 0) {
         return qb[n];
     }
     
     int fibn = fibMemoised(n-1,qb) + fibMemoised(n-2,qb);
     qb[n] = fibn;
     
     return fibn;
 }
 
 public static int fibTabulated(int n) {
     int[]dp = new int[n+1];
     dp[0]=0;
     dp[1]=1;
     
     for(int i=2; i <= n;i++) {
         dp[i] = dp[i-1] + dp[i-2];
     }
     
     return dp[n];
 }
 

}