import java.io.*;
import java.util.*;

public class Main {

    private static void optimalbst(int[] keys, int[] freq, int n) {
        int[][] dp = new int[n][n];

        for (int d = 0; d < n; d++) {
            for (int i = 0, j = d; j < n; i++, j++) {
                if (d == 0) {
                    dp[i][j] = freq[i];
                } 
                else if (d == 1) {
                    dp[i][j] = Math.min(freq[i] + 2 * freq[j], 2 * freq[i] + freq[j]);
                } 
                else {
                    int fs = 0;
                    int min = Integer.MAX_VALUE;

                    for (int k = i; k <= j; k++) {
                        int lp = (k == 0) ? 0 : dp[i][k - 1];
                        int rp = (k + 1 == n) ? 0 : dp[k + 1][j];
                        min = Math.min(lp + rp, min);

                        fs += freq[k];
                    }

                    dp[i][j] = min + fs;
                }
            }
        }

        System.out.println(dp[0][n - 1]);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] keys = new int[n];
        int[] frequency = new int[n];
        for (int i = 0; i < n; i++) {
            keys[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            frequency[i] = scn.nextInt();
        }
        optimalbst(keys, frequency, n);
    }

}