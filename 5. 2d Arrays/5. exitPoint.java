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

        exitPoint(mat);
    }

    public static void exitPoint(int[][] mat) {
        int i = 0;
        int j = 0;
        int dir = 0; //east

        //0->east, 1->south, 2->west, 3->north

        while (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length) {
            dir = (dir + mat[i][j]) % 4;

            if (dir == 0) {
                //east
                j++;

                if (j == mat[0].length) {
                    j--;
                    break;
                }
            } else if (dir == 1) {
                //south
                i++;

                if (i == mat.length) {
                    i--;
                    break;
                }
            } else if (dir == 2) {
                //west
                j--;

                if (j == -1) {
                    j++;
                    break;
                }
            } else if (dir == 3) {
                //north
                i--;

                if (i == -1) {
                    i++;
                    break;
                }
            }
        }

        System.out.println(i);
        System.out.println(j);
    }

}
