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

        longestConsecutiveSeq(arr);
    }

    public static void longestConsecutiveSeq(int[] arr) {

        HashMap < Integer, Boolean > hm = new HashMap < > ();

        //assume each element is a sequence start
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], true);
        }

        //to find real sequence start
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i] - 1) == true) {
                hm.put(arr[i], false);
            }
        }

        int ost = 0;
        int ol = 0;

        //find longest consective seq
        for (int i = 0; i < arr.length; i++) {
            if (hm.get(arr[i]) == true) {
                //arr[i] is a seq start
                int len = 0;
                while (hm.containsKey(arr[i] + len)) {
                    len++;
                }

                if (len > ol) {
                    ol = len;
                    ost = arr[i];
                }
            }
        }


        for (int i = 0; i < ol; i++) {
            System.out.println(ost + i);
        }

    }


}