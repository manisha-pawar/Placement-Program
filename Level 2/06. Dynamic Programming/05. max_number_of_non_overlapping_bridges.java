import java.io.*;
import java.util.*;

public class Main {

    public static class Bridge implements Comparable<Bridge>{
        int nc;
        int sc;
        
        Bridge() {
            
        }
        
        Bridge(int nc,int sc) {
            this.nc = nc;
            this.sc = sc;
        }
        
        public int compareTo(Bridge o) {
            if(this.nc == o.nc) {
                return this.sc - o.sc;
            }
            else {
                return this.nc - o.nc;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        Bridge[]arr = new Bridge[n];
        
        for(int i=0; i < n;i++) {
            int nc = scn.nextInt();
            int sc = scn.nextInt();
            
            arr[i] = new Bridge(nc,sc);
        }
        
        int count = nonOverlappingBridges(arr);
        System.out.println(count);
    }
    
    
    public static int nonOverlappingBridges(Bridge[]arr) {
        //1. sort on the basis of north
        Arrays.sort(arr);
        
        //perform lis on the basis of south
        int omax = 0;
        int[]dp = new int[arr.length];
        
        for(int i=0; i < arr.length;i++) {
            int max = 0;
            for(int j=0; j < i;j++) {
                if(arr[j].sc < arr[i].sc) {
                    max = Math.max(dp[j],max);
                }
            }
            
            dp[i] = max + 1;
            
            omax = Math.max(omax,dp[i]);
        }
        
        return omax;
        
    }

}