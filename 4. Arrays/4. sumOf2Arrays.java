import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];

        //input first array
        for (int i = 0; i < n1; i++) {
            a1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] a2 = new int[n2];

        //take second array
        for (int i = 0; i < n2; i++) {
            a2[i] = scn.nextInt();
        }

        int[] ans = sumOfTwoArrays(a1, a2);

        //print ans array
        for (int i = 0; i < ans.length; i++) {
            if (i == 0 && ans[0] == 1) {
                System.out.println(ans[i]);
            } else if (i > 0) {
                System.out.println(ans[i]);
            }
        }
    }

    public static int[] sumOfTwoArrays(int[] a1, int[] a2) {
        int len = a1.length > a2.length ? a1.length + 1 : a2.length + 1;
        int[] ans = new int[len];

        int i = a1.length - 1;
        int j = a2.length - 1;
        int k = ans.length - 1;

        int carry = 0;

        //find sum of two arrays
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a1[i];
            }
            if (j >= 0) {
                sum += a2[j];
            }

            int val = sum % 10;
            carry = sum / 10;
            ans[k] = val;

            i--;
            j--;
            k--;
        }

        return ans;
    }


}
