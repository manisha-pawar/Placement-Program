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

        int[] ans = diffOf2Arrays(a1, a2);

        int fnzi = -1; //first non zero index

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != 0) {
                fnzi = i;
                break;
            }
        }

        if (fnzi == -1) {
            System.out.println("0");
            return;
        }

        for (int i = fnzi; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }

    public static int[] diffOf2Arrays(int[] a1, int[] a2) {
        int[] ans = new int[a2.length];

        int i = a1.length - 1;
        int j = a2.length - 1;
        int k = ans.length - 1;

        int borrow = 0;

        while (j >= 0) {
            int sub = (a2[j] + borrow);

            if (i >= 0) {
                sub = sub - a1[i];
            }

            int val = sub;

            if (sub < 0) {
                val = val + 10;
                borrow = -1;
            } else {
                borrow = 0;
            }

            ans[k] = val;

            i--;
            j--;
            k--;
        }

        return ans;
    }

}
