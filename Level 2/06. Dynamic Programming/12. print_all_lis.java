import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static class Pair {
        int l;
        int i;
        int v;
        String psf;

        Pair(int l, int i, int v, String psf) {
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }

    public static void solution(int[] arr) {
        int[] dp = new int[arr.length];

        int omax = 0;

        for (int i = 0; i < arr.length; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }

            dp[i] = max + 1;

            omax = Math.max(omax, dp[i]);
        }


        System.out.println(omax);
        printAllPath(arr, dp, omax);

    }

    public static void printAllPath(int[] arr, int[] dp, int omax) {
        ArrayDeque < Pair > q = new ArrayDeque < > ();

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == omax) {
                q.add(new Pair(dp[i], i, arr[i], arr[i] + ""));
            }
        }

        while (q.size() > 0) {
            Pair rem = q.remove();

            if (rem.l == 1) {
                System.out.println(rem.psf);
                continue;
            }

            for (int j = rem.i - 1; j >= 0; j--) {
                if (arr[j] < arr[rem.i] && dp[j] == dp[rem.i] - 1) {
                    q.add(new Pair(dp[j], j, arr[j], arr[j] + " -> " + rem.psf));
                }
            }
        }
    }



    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}