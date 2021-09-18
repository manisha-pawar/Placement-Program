import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println(LIS(arr));
    }

    public static int LIS(int[] arr) {
        int[] dp = new int[arr.length];
        int omax = 0;

        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(dp[j], max);
                }
            }

            dp[i] = max + 1;

            omax = Math.max(omax, dp[i]);
        }

        return omax;
    }



}