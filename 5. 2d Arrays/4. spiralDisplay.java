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

        spiralDisplay(mat);
    }

    public static void spiralDisplay(int[][] mat) {
        int rs = 0;
        int cs = 0;
        int re = mat.length - 1;
        int ce = mat[0].length - 1;

        int tne = mat.length * mat[0].length;
        int count = 0;

        while (count < tne) {
            //left wall
            for (int k = rs; k <= re && count < tne; k++) {
                System.out.println(mat[k][cs]);
                count++;
            }
            cs++;

            //bottom wall
            for (int k = cs; k <= ce && count < tne; k++) {
                System.out.println(mat[re][k]);
                count++;
            }
            re--;

            //right wall
            for (int k = re; k >= rs && count < tne; k--) {
                System.out.println(mat[k][ce]);
                count++;
            }
            ce--;

            //top wall
            for (int k = ce; k >= cs && count < tne; k--) {
                System.out.println(mat[rs][k]);
                count++;
            }
            rs++;
        }
    }

}
