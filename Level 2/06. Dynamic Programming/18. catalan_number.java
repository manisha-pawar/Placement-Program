import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println(catalan(n));
    }

    public static int catalan(int n) {
        int[] dp = new int[n + 1];

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int temp = 0;
            for (int l = 0, r = i - 1; l <= i - 1; l++, r--) {
                temp += dp[l] * dp[r];
            }
            dp[i] = temp;
        }

        return dp[n];
    }

}