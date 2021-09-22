import java.io.*;
import java.util.*;

public class Main {

   private static class Pair {
      String psf;
      int i;
      int j;

      public Pair(String psf, int i, int j) {
         this.psf = psf;
         this.i = i;
         this.j = j;
      }
   }
   
   public static void minCost(int[][]cost) {
       int n = cost.length;
       int m = cost[0].length;
       
       int[][]dp = new int[n][m];
       
       for(int i = n-1; i >= 0;i--) {
           for(int j = m-1; j >= 0;j--) {
               if(i == n-1 && j == m-1) {
                   dp[i][j] = cost[i][j];
               }
               else if(i == n-1) {
                   dp[i][j] = cost[i][j] + dp[i][j+1];
               }
               else if(j == m-1) {
                   dp[i][j] = cost[i][j] + dp[i+1][j];
               }
               else {
                   dp[i][j] = Math.min(dp[i][j+1],dp[i+1][j]) + cost[i][j];
               }
           }
       }
       
       System.out.println(dp[0][0]);
       
       //printPath(0,0,"",dp);
       
       printPath(dp);
   }
   
   //using dfs
   public static void printPath(int i,int j,String psf,int[][]dp) {
       if(i == dp.length-1 && j == dp[0].length-1) {
           System.out.println(psf);
           return;
       }
       
       if(i == dp.length-1) {
           printPath(i,j+1,psf + "H",dp);
       }
       else if(j == dp[0].length-1) {
           printPath(i+1,j,psf + "V",dp);
       }
       else {
           //both options
           int minc = Math.min(dp[i][j+1],dp[i+1][j]);
           
           if(dp[i+1][j] == minc) {
                printPath(i+1,j,psf + "V",dp);
           }
           if(dp[i][j+1] == minc) {
               printPath(i,j+1,psf + "H",dp);
           }
           
       }
   }

    //using bfs
    public static void printPath(int[][]dp) {
        
       ArrayDeque<Pair>q = new ArrayDeque<>();
       q.add(new Pair("",0,0));
       
       while(q.size() > 0) {
           Pair rem = q.remove();
           
           int i = rem.i;
           int j = rem.j;
           String psf = rem.psf;
           
           if(i == dp.length-1 && j == dp[0].length-1) {
               System.out.println(psf);
               continue;
           }
           
           if(i == dp.length-1) {
               q.add(new Pair(psf + "H",i,j+1));
           }
           else if(j == dp[0].length-1) {
               q.add(new Pair(psf + "V",i+1,j));
           }
           else {
               //both options
               int minc = Math.min(dp[i][j+1],dp[i+1][j]);
               
               if(dp[i+1][j] == minc) {
                    q.add(new Pair(psf + "V",i+1,j));
               }
               if(dp[i][j+1] == minc) {
                   q.add(new Pair(psf + "H",i,j+1));
               }
               
           }
       }
   }
   

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }

      //write your code here
      minCost(arr);
      
   }

}