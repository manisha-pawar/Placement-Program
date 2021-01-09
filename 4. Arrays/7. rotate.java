import java.io.*;
import java.util.*;

public class Main {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val: a) {
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void reverse(int[] a, int li, int ri) {

        while (li < ri) {
            int lv = a[li];
            int rv = a[ri];
            a[li] = rv;
            a[ri] = lv;

            li++;
            ri--;
        }
    }

    public static void rotate(int[] a, int k) {
        // write your code here
        int n = a.length;

        k = k % n;

        if (k < 0) {
            k = k + n;
        }

        //reverse complete array
        reverse(a, 0, n - 1);
        //reverse part1
        reverse(a, 0, k - 1);
        //reverse part2
        reverse(a, k, n - 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        rotate(a, k);
        display(a);
    }

}
