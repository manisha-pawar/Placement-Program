import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = scn.nextInt();

        int[][] mat = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        int s = scn.nextInt();
        int r = scn.nextInt();

        //fill 1d array with s shell's elements of matrix
        int[] arr = fill1dArray(mat, s);
        //rotate this array by r
        rotate(arr, r);
        //fill 2d matrix's s shell with rotated array
        fill2dArray(mat, arr, s);

        display(mat);

    }

    public static int[] fill1dArray(int[][] mat, int s) {
        int row = mat.length;
        int col = mat[0].length;
        int rs = s - 1;
        int cs = s - 1;
        int re = row - s;
        int ce = col - s;

        //total elements in shell 's'
        int tnes = 2 * (ce - cs) + 2 * (re - rs);
        int[] arr = new int[tnes];
        int idx = 0;

        //left wall
        for (int i = rs; i <= re; i++) {
            arr[idx] = mat[i][cs];
            idx++;
        }
        cs++;

        //bottom wall
        for (int i = cs; i <= ce; i++) {
            arr[idx] = mat[re][i];
            idx++;
        }
        re--;

        //right wall
        for (int i = re; i >= rs; i--) {
            arr[idx] = mat[i][ce];
            idx++;
        }
        ce--;

        //top wall
        for (int i = ce; i >= cs; i--) {
            arr[idx] = mat[rs][i];
            idx++;
        }
        rs++;

        return arr;
    }

    public static void fill2dArray(int[][] mat, int[] arr, int s) {
        int row = mat.length;
        int col = mat[0].length;
        int rs = s - 1;
        int cs = s - 1;
        int re = row - s;
        int ce = col - s;

        int idx = 0;

        //left wall
        for (int i = rs; i <= re; i++) {
            mat[i][cs] = arr[idx];
            idx++;
        }
        cs++;

        //bottom wall
        for (int i = cs; i <= ce; i++) {
            mat[re][i] = arr[idx];
            idx++;
        }
        re--;

        //right wall
        for (int i = re; i >= rs; i--) {
            mat[i][ce] = arr[idx];
            idx++;
        }
        ce--;

        //top wall
        for (int i = ce; i >= cs; i--) {
            mat[rs][i] = arr[idx];
            idx++;
        }
        rs++;

    }
    public static void rotate(int[] arr, int k) {
        int n = arr.length;

        k = k % n;

        if (k < 0) {
            k = k + n;
        }

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    public static void reverse(int[] arr, int lo, int hi) {
        while (lo <= hi) {
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;

            lo++;
            hi--;
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
