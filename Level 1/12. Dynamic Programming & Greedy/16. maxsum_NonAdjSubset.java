import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        
        int[]arr = new int[n];
        
        for(int i=0;i<arr.length;i++) {
            arr[i]=scn.nextInt();
        }
        
        int ans = maxSum(arr);
        System.out.println(ans);
    }
    
    public static int maxSum(int[]arr) {
       
        int inc = 0;
        int exc = 0;
        
        for(int i=0; i < arr.length;i++) {
            int ninc = exc + arr[i];
            int nexc = Math.max(inc,exc);
            
            inc = ninc;
            exc = nexc;
        }
        
        return Math.max(inc,exc);
        
    }
}