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

        print(arr);
    }

    public static void print(int[] arr) {
        //find max of array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int h = max; h >= 1; h--) {
            for (int i = 0; i < arr.length; i++) {
                //star
                if (h <= arr[i]) {
                    System.out.print("*\t");
                }
                //space
                else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

    }

}
