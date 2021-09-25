import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        //write your code here
        
        knapsack(values,wts,cap);
        
    }
    
    public static void knapsack(int[]value,int[]wt,int cap) {
        
        int n = value.length;
        
        int[][]dp = new int[n+1][cap+1];
        
        for(int i=0; i < dp.length;i++) {
            for(int j=0; j < dp[0].length;j++) {
                if(i == 0) {
                    //no item
                    dp[i][j] = 0;
                }
                else if(j == 0) {
                    //no capacity
                    dp[i][j] = 0;
                }
                else {
                    int exc = dp[i-1][j];
                    int inc = 0;
                    
                    int k = i-1; //item's idx
                    if(j >= wt[k]) {
                        inc = dp[i-1][j - wt[k]] + value[k];
                    }
                    
                    dp[i][j] = Math.max(inc,exc);
                }
            }
        }
        
        System.out.println(dp[n][cap]);
        printAllPaths(dp,value,wt);
    }
    
    
    public static class Pair {
        int i;
        int j;
        String psf;
        
        Pair() {
            
        }
        
        Pair(int i,int j,String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    
    public static void printAllPaths(int[][]dp,int[]value,int[]wt) {
        int n = value.length;
        int cap = dp[0].length - 1;
        
        ArrayDeque<Pair>q = new ArrayDeque<>();
        
        q.add(new Pair(n,cap,""));
        
        while(q.size() > 0) {
            Pair rem = q.remove();
            int i = rem.i;
            int j = rem.j;
            String psf = rem.psf;
            
            
            if(j == 0 || i == 0) {
                System.out.println(psf);
                continue;
            }
            
            int exc = dp[i-1][j];
            int inc = 0;
            
            int k = i-1; //item's idx
            if(j >= wt[k]) {
                inc = dp[i-1][j - wt[k]] + value[k];
            }
            
            if(dp[i][j] == exc) {
                q.add(new Pair(i-1,j,psf));
            }
            if(dp[i][j] == inc) {
                if(j >= wt[k]) {
                    q.add(new Pair(i-1,j - wt[k],k + " " + psf));
                }
            }
            
        }
    }
}

                        