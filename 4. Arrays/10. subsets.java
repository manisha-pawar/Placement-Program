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

        printSubsets(arr);
    }

    public static void printSubsets(int[] arr) {
        int n = arr.length;
        int ts = (int) Math.pow(2, n);

        for (int d = 0; d < ts; d++) {
            int[] subset = decToBinary(d, n);

            for (int i = 0; i < n; i++) {
                if (subset[i] == 0) {
                    System.out.print("-\t");
                } else if (subset[i] == 1) {
                    System.out.print(arr[i] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static int[] decToBinary(int n, int len) {
        int[] bin = new int[len];
        int i = len - 1;

        while (n != 0) {
            int rem = n % 2;
            bin[i] = rem;

            n = n / 2;
            i--;
        }

        return bin;
    }

}
