import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        int ans = encodings(str);
        System.out.println(ans);
    }
    
    public static int encodings(String str) {
        str = "." + str;
        int n = str.length();
        
        int[]dp = new int[n];
        
        dp[0] = 1;
        
        if(str.charAt(1) != 0) {
            dp[1] = 1;
        }
        
        for(int i=2; i < dp.length;i++) {
            char cch = str.charAt(i);
            char lch = str.charAt(i-1);
            
            if(cch == '0' && lch == '0') {
                dp[i] = 0;
            }
            else if(cch !='0' && lch == '0') {
                dp[i] = dp[i-1];
            }
            else if(cch == '0' && lch != '0') {
                if(lch == '1' || lch == '2') {
                    dp[i] = dp[i-2];
                }
            }
            else {
                dp[i] = dp[i-1];
                
                int num = Integer.parseInt("" + lch + cch);
                
                if(num <= 26) {
                    dp[i] += dp[i-2];
                }
            }
        }
        
        return dp[n-1];
    }
}