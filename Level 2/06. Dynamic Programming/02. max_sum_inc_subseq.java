import java.util.*;

public class Main {

    // This is a functional problem. You have to complete this function.
    // It takes as input an integer array. It should return the required sum.
    public static int maxSum(int[] a) {
        // write your code here.

        int[] dp = new int[a.length];
        int omax = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    max = Math.max(max, dp[j]);
                }
            }

            dp[i] = max + a[i];

            omax = Math.max(dp[i], omax);
        }

        return omax;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maxSum(arr));

    }

}