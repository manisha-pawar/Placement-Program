import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        printMazePaths(0, 0, n - 1, m - 1, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {

        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }

        //horizontal moves 
        for (int jump = 1; sc + jump <= dc; jump++) {
            printMazePaths(sr, sc + jump, dr, dc, psf + "h" + jump);
        }

        //vertical moves
        for (int jump = 1; sr + jump <= dr; jump++) {
            printMazePaths(sr + jump, sc, dr, dc, psf + "v" + jump);
        }

        //diagonal moves
        for (int jump = 1; sr + jump <= dr && sc + jump <= dc; jump++) {
            printMazePaths(sr + jump, sc + jump, dr, dc, psf + "d" + jump);
        }
    }

}
