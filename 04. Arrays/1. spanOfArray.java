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

        int ans = span(arr);
        System.out.println(ans);
    }

    public static int span(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        //find min-max
        for (int i = 1; i < arr.length; i++) {
            int cv = arr[i];

            if (cv > max) {
                max = cv;
            }

            if (cv < min) {
                min = cv;
            }
        }

        int ans = max - min;
        return ans;
    }

}
