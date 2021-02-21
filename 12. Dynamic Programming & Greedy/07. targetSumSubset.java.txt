import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[]arr=new int[n];
        
        for(int i=0;i<n;i++) {
            arr[i]=scn.nextInt();
        }
        
        int tar = scn.nextInt();
        
        boolean ans = targetSumSubset(arr,tar);
        System.out.println(ans);
    }
    
    public static boolean targetSumSubset(int[]arr,int tar) {
        boolean[][]dp = new boolean[arr.length+1][tar+1];
        
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j < dp[0].length;j++) {
                if(j == 0) {
                    dp[i][j] = true;
                }
                else if(i == 0) {
                    dp[i][j] = false;
                }
                else {
                    boolean no = dp[i-1][j]; // no batting
                    boolean yes = false;
                    
                    if(j >= arr[i-1]) {
                       yes = dp[i-1][j-arr[i-1]]; // batting
                    }
                    
                    dp[i][j] = no || yes;
                    
                }
            }
        }
        
        return dp[arr.length][tar];
    }
}