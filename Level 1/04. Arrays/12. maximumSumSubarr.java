//using kadane's algo

import java.util.*;

public class Main {

    // This is a functional problem. You have to complete this function.
    // It takes as input an integer array. It should return the required sum.
    public static int maxSum(int[] arr) {
        // write your code here
        int cs = arr[0];
        int ms = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (cs < 0) {
                cs = arr[i];
            } else {
                cs = cs + arr[i];
            }

            if (cs > ms) {
                ms = cs;
            }
        }

        return ms;
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
