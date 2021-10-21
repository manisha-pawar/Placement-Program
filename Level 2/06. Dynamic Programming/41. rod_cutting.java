import java.io.*;
import java.util.*;

public class Main {

    //cut strategy
    public static int solution(int[] prices) {
        int[] p = new int[prices.length + 1];

        for (int i = 0; i < prices.length; i++) {
            p[i + 1] = prices[i];
        }

        int[] dp = new int[p.length];

        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int c = 1; c <= i; c++) {
                int pr = p[c] + dp[i - c];
                max = Math.max(pr, max);
            }
            dp[i] = max;
        }

        return dp[dp.length - 1];
    }



    //left-right strategy
    public static int solution(int[] prices) {
        int[] p = new int[prices.length + 1];

        for (int i = 0; i < prices.length; i++) {
            p[i + 1] = prices[i];
        }

        int[] dp = new int[p.length];

        for (int i = 1; i < dp.length; i++) {
            int max = p[i];

            int l = 1;
            int r = i - 1;

            while (l <= r) {
                int pr = dp[l] + dp[r];
                max = Math.max(pr, max);

                l++;
                r--;
            }

            dp[i] = max;
        }
        return dp[dp.length - 1];
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.println(solution(prices));
    }

}