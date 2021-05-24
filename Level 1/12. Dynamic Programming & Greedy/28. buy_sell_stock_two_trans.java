import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        
        int[]prices = new int[n];
        
        for(int i=0;i < n;i++) {
            prices[i] = scn.nextInt();
        }
        
        int ans = twoTranscn(prices);
        System.out.println(ans);
    }
    
    public static int twoTranscn(int[]prices) {
        int n=prices.length;
        
        int[]dp1 = new int[n]; // dp1[i] -> 0 to i one transaction best result
        int[]dp2 = new int[n]; // dp2[i] -> i to n one transaction best result
        
        //fill dp1
        int lpsf = prices[0];
        for(int i=1;i < n;i++) {
            if(prices[i] < lpsf) {
                lpsf = prices[i];
            }
            
            int cb = dp1[i-1]; // completed before i
            int ci = prices[i] - lpsf; // completed at i
            
            dp1[i] = Math.max(cb,ci);
        }
        
        //fill dp2
        int mpsf = prices[n-1];
        for(int i=n-2;i >= 0;i--) {
            if(prices[i] > mpsf) {
                mpsf = prices[i];
            }
            
            int ca = dp2[i+1]; //completed after i
            int ci = mpsf - prices[i];// buy point is i
            
            dp2[i] = Math.max(ca,ci);
        }
        
        int max = 0;
        
        for(int i=0; i < n;i++) {
            if(dp1[i] + dp2[i] > max) {
                max = dp1[i] + dp2[i];
            }
        }
        
        return max;
    }

}