import java.util.*;
  
  public class Main {
  
  	  public static void main(String[] args) {
  	  	  // TODO Auto-generated method stub
          Scanner scn= new Scanner(System.in);
          int n=scn.nextInt();
          int[][] costs= new int[n][3];
          for(int i=0;i<n;i++){
              for(int j=0;j<3;j++){
                  costs[i][j]=scn.nextInt();
              }
          }
          System.out.println(minCostVar(costs));
  	  }
  	  // -----------------------------------------------------
  	  // This is a functional problem. Only this function has to be written.
  	  // This function takes as input 2D array
  	  // It should return the required output
  
  	  public static int minCost(int[][] cost) {
  	  	  //Write your code here
  	  	  int n=cost.length;
  	  	  
  	  	  int[][]dp = new int[n][3];
  	  	  dp[0][0] = cost[0][0];
  	  	  dp[0][1] = cost[0][1];
  	  	  dp[0][2] = cost[0][2];
  	  	  
  	  	  for(int i=1; i < n;i++) {
  	  	      for(int j=0; j < 3;j++) {
  	  	          if(j == 0) {
  	  	              //(red color)
  	  	              dp[i][j] = cost[i][j] + Math.min(dp[i-1][1],dp[i-1][2]);
  	  	          }
  	  	          else if(j == 1) {
  	  	              //(green color)
  	  	              dp[i][j] = cost[i][j] + Math.min(dp[i-1][0],dp[i-1][2]);
  	  	          }
  	  	          else if(j == 2) {
  	  	              //blue color
  	  	               dp[i][j] = cost[i][j] + Math.min(dp[i-1][0],dp[i-1][1]);
  	  	          }
  	  	      }
  	  	  }
  	  	  
  	  	  int ans = Math.min(Math.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]);
  	  	  return ans;
  	  }
  	  
  	  public static int minCostVar(int[][]cost) {
  	      int r = 0;
  	      int g = 0;
  	      int b = 0;
  	      
  	      for(int h = 0; h < cost.length;h++) {
  	          //red color
  	          int nr = cost[h][0] + Math.min(b,g);
  	          //green color
  	          int ng = cost[h][1] + Math.min(r,b);
  	          //blue color
  	          int nb = cost[h][2] + Math.min(r,g);
  	          
  	          r = nr;
  	          b = nb;
  	          g = ng;
  	      }
  	      
  	      return Math.min(Math.min(r,g),b);
  	  }
  	  
  	  
  }