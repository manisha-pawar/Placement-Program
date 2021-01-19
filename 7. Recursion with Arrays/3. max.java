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

        int max = maxOfArray(arr, 0);
        System.out.println(max);
    }

    public static int maxOfArray(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            //only one element
            return arr[idx];
        }

        int smax = maxOfArray(arr, idx + 1);
        int max = 0;

        if (arr[idx] > smax) {
            max = arr[idx];
        } 
        else {
            max = smax;
        }

        return max;
    }

}
