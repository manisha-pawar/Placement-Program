import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static class Pair {
        int i;
        String psf;

        Pair() {

        }

        Pair(int i, String psf) {
            this.i = i;
            this.psf = psf;
        }
    }
    
    public static void Solution(int arr[]) {

        int n = arr.length;
        int[] dp = new int[n];

        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= arr[i] && i + j < n; j++) {
                if (dp[i + j] < min) {
                    min = dp[i + j];
                }
            }

            if (min == Integer.MAX_VALUE) {
                dp[i] = min;
            } else {
                dp[i] = min + 1;
            }
        }

        System.out.println(dp[0]);

        if (dp[0] != Integer.MAX_VALUE)
            printAllPaths(arr, dp);
    }

    public static void printAllPaths(int[] arr, int[] dp) {
        ArrayDeque < Pair > q = new ArrayDeque < > ();

        int n = arr.length;

        q.add(new Pair(0, "0"));

        while (q.size() > 0) {
            Pair rem = q.remove();
            int i = rem.i;

            if (i == n - 1) {
                System.out.println(rem.psf + " .");
                continue;
            }

            for (int j = 1; j <= arr[i] && i + j < n; j++) {
                if (dp[i + j] == dp[i] - 1) {
                    q.add(new Pair(i + j, rem.psf + " -> " + (i + j)));
                }
            }
        }
    }



    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }


}