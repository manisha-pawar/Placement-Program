import java.io.*;
import java.util.*;

public class Main {

    public static void optimalStrategy(int[] arr) {

        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int d = 0; d < n; d++) {
            for (int i = 0, j = d; j < n; i++, j++) {
                if (d == 0) {
                    dp[i][j] = arr[i];
                } else if (d == 1) {
                    dp[i][j] = Math.max(arr[i], arr[j]);
                } else {
                    //if I chooses 'i'
                    int c1 = Math.min(dp[i + 2][j], dp[i + 1][j - 1]) + arr[i];

                    //if I chooses 'j'
                    int c2 = Math.min(dp[i + 1][j - 1], dp[i][j - 2]) + arr[j];

                    dp[i][j] = Math.max(c1, c2);
                }
            }
        }

        System.out.println(dp[0][n - 1]);

    }

    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
        optimalStrategy(a);
    }

}