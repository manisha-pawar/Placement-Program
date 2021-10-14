import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        System.out.println(lps(str));
    }

    public static int lps(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        for (int d = 0; d < n; d++) {
            for (int i = 0, j = d; j < n; i++, j++) {
                if (d == 0) {
                    dp[i][j] = 1;
                } 
                else if (d == 1) {
                    dp[i][j] = (str.charAt(i) == str.charAt(j)) ? 2 : 1;
                } 
                else {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } 
                    else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

}