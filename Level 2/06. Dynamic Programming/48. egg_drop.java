import java.io.*;
import java.util.*;

public class Main {

    public static int eggDrop(int e, int f) {
        int[][] dp = new int[e + 1][f + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i == 1) {
                    //only 1 egg
                    dp[i][j] = j;
                } 
                else if (j == 1) {
                    //only 1 floor
                    dp[i][j] = 1;
                } 
                else {
                    int min = Integer.MAX_VALUE;

                    for (int k = 1; k <= j; k++) {
                        int eb = dp[i - 1][k - 1];
                        int es = dp[i][j - k];
                        int max = Math.max(eb, es); //out of control

                        min = Math.min(min, max);
                    }
                    dp[i][j] = min + 1;
                }
            }
        }

        return dp[e][f];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //n -> number of eggs and k -> number of floors
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(eggDrop(n, k));
    }

}