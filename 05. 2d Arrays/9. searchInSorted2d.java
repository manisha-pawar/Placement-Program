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

        int ele = scn.nextInt();

        search(mat, ele);
    }

    public static void search(int[][] mat, int ele) {
        int i = 0;
        int j = mat[0].length - 1;

        while (i < mat.length && j >= 0) {
            if (mat[i][j] == ele) {
                System.out.println(i + "\n" + j);
                return;
            } 
            else if (mat[i][j] > ele) {
                j--;
            } 
            else if (mat[i][j] < ele) {
                i++;
            }
        }

        System.out.println("Not Found");

    }

}
