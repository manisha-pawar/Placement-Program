import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] mat = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        print(mat);
    }

    public static void print(int[][] mat) {

        for (int j = 0; j < mat[0].length; j++) {
            if (j % 2 == 0) {
                //col even -> top to bottom
                for (int i = 0; i < mat.length; i++) {
                    System.out.println(mat[i][j]);
                }
            } else {
                //col odd -> bottom to top
                for (int i = mat.length - 1; i >= 0; i--) {
                    System.out.println(mat[i][j]);
                }
            }
        }
    }

}
