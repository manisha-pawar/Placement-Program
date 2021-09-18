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

        System.out.println(lbs(arr));
    }

    public static int lbs(int[] arr) {

        int[] lis = new int[arr.length];
        int[] lds = new int[arr.length];

        //lis
        for (int i = 0; i < arr.length; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, lis[j]);
                }
            }

            lis[i] = max + 1;
        }

        //lds
        for (int i = arr.length - 1; i >= 0; i--) {
            int max = 0;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, lds[j]);
                }
            }

            lds[i] = max + 1;
        }

        int oans = 0;

        //lbs
        for (int i = 0; i < arr.length; i++) {
            int len = lis[i] + lds[i] - 1;

            if (oans < len) {
                oans = len;
            }
        }

        return oans;
    }


}