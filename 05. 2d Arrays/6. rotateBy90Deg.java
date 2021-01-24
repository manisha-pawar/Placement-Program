import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        //1. transpose
        transpose(mat);
        //2. column reversal
        columnReversal(mat);

        display(mat);

    }

    public static void transpose(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = i; j < mat[0].length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    public static void columnReversal(int[][] mat) {
        int lc = 0;
        int rc = mat[0].length - 1;

        while (lc < rc) {
            for (int i = 0; i < mat.length; i++) {
                int lv = mat[i][lc];
                int rv = mat[i][rc];

                mat[i][lc] = rv;
                mat[i][rc] = lv;
            }

            lc++;
            rc--;
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
