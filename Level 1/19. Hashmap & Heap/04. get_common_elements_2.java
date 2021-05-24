import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];

        for (int i = 0; i < n1; i++) {
            a1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] a2 = new int[n2];

        for (int i = 0; i < n2; i++) {
            a2[i] = scn.nextInt();
        }

        printCommonEle2(a1, a2);

    }

    public static void printCommonEle2(int[] a1, int[] a2) {
        HashMap < Integer, Integer > hm = new HashMap < > ();

        //fill hm using first array
        for (int i = 0; i < a1.length; i++) {

            if (hm.containsKey(a1[i]) == false) {
                hm.put(a1[i], 1);
            } else {
                int nf = hm.get(a1[i]) + 1;
                hm.put(a1[i], nf);
            }
        }

        //travel second array
        for (int i = 0; i < a2.length; i++) {

            if (hm.containsKey(a2[i]) == true && hm.get(a2[i]) > 0) {
                System.out.println(a2[i]);
                int nf = hm.get(a2[i]) - 1;
                hm.put(a2[i], nf);
            }
        }

    }

}