import java.util.Scanner;
import java.util.*;

public class Main {

    //T : O(m)
    public static int solution(int m, int[] x, int[] rev, int t) {
        int[] dp = new int[m + 1];

        HashMap < Integer, Integer > map = new HashMap < > (); //posn vs revenue of a billboard

        for (int i = 0; i < x.length; i++) {
            map.put(x[i], rev[i]);
        }

        dp[0] = (map.containsKey(0) == true) ? map.get(0) : 0;

        for (int i = 1; i < dp.length; i++) {
            int exc = dp[i - 1];
            int inc = 0;

            if (map.containsKey(i) == true) {
                //ith posn has a billboard
                inc = map.get(i);

                if (i - t - 1 >= 0) {
                    inc += dp[i - t - 1];
                }
            }

            dp[i] = Math.max(exc, inc);
        }

        return dp[m];

    }


    //T : O(n^2)
    public static int solution(int m, int[] x, int[] rev, int t) {
        //assuming that x is sorted, hashmap is not required

        int[] dp = new int[x.length];

        dp[0] = rev[0];
        int omax = 0;

        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                int dist = x[i] - x[j];

                if (dist > t) {
                    max = Math.max(dp[j], max);
                }
            }

            dp[i] = max + rev[i];
            omax = Math.max(omax, dp[i]);
        }


        return omax;

    }
    public static void input(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue, scn);

        int t = scn.nextInt();

        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}