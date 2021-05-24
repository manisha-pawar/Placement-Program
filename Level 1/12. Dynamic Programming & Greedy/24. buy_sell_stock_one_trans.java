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
        
        int ans = oneTranscn(prices);
        System.out.println(ans);
    }
    
    public static int oneTranscn(int[]prices) {
        int lpsf = Integer.MAX_VALUE; // least price of stock so far
        int omp = Integer.MIN_VALUE; // overall max profit 
        
        for(int i=0; i < prices.length;i++) {
            if(prices[i] < lpsf) {
                lpsf = prices[i];
            }
            
            int cp = prices[i] - lpsf;
            
            if(cp > omp) {
                omp = cp;
            }
        }
        
        return omp;
    }

}