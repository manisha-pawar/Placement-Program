import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];

        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];

        for (int i = 0; i < n2; i++) {
            arr2[i] = scn.nextInt();
        }

        printCommonEle(arr1, arr2);

    }


    public static void printCommonEle(int[] a1, int[] a2) {

        HashMap < Integer, Integer > hm = new HashMap < > ();

        //populate hm using first array
        for (int i = 0; i < a1.length; i++) {

            int val = a1[i];

            if (hm.containsKey(val) == false) {
                hm.put(val, 1);
            } else {
                int nf = hm.get(val) + 1;
                hm.put(val, nf);
            }
        }

        //travel 2nd array
        for (int i = 0; i < a2.length; i++) {
            int val = a2[i];

            if (hm.containsKey(val) == true) {
                System.out.println(val);
                hm.remove(val);
            }
        }
    }

}