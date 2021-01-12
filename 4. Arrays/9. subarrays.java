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

        printSubarrays(arr);
    }

    public static void printSubarrays(int[] arr) {
        //select a start point
        for (int st = 0; st < arr.length; st++) {
            //select end point
            for (int et = st; et < arr.length; et++) {
                //print subarray from st to et
                for (int k = st; k <= et; k++) {
                    System.out.print(arr[k] + "\t");
                }
                System.out.println();
            }
        }
    }

}
