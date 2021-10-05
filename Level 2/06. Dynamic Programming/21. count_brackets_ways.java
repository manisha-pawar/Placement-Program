import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        System.out.println(ways(n));
    }

    public static int ways(int n) {
        int[] dp = new int[n + 1];

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int l = 0;
            int r = i - 1;

            while (l <= i - 1) {
                dp[i] += dp[l] * dp[r];
                l++;
                r--;
            }
        }

        return dp[n];
    }

}