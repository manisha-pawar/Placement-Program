import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        longest_pal_substring(str);
    }
    
    public static void longest_pal_substring(String s) {
        int n = s.length();
        boolean[][]dp = new boolean[n][n];
        int count = 0;
        
        int li = -1;
        int lj = -1;
        
        
        for(int d = 0; d < n;d++) {
            for(int i = 0,j = d; j < n; i++,j++) {
                if(d == 0) {
                    //one length substrings
                    dp[i][j] = true;
                }
                else if(d == 1) {
                    //two length substrings
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = false;
                    }
                }
                else {
                    //substring with length > 2
                    dp[i][j] =  s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }
                
                if(dp[i][j] == true) {
                    li = i;
                    lj = j;
                }
            }
        }
        
        int len = lj - li + 1;
        System.out.println(len);
    }

}