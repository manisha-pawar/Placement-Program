import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        ArrayList < String > ans = getMazePaths(0, 0, n - 1, m - 1);
        System.out.println(ans);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList < String > getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList < String > base = new ArrayList < > ();
            base.add("");
            return base;
        }

        ArrayList < String > rightToDest = new ArrayList < > ();
        ArrayList < String > downToDest = new ArrayList < > ();

        //horizontal move
        if (sc + 1 <= dc) {
            rightToDest = getMazePaths(sr, sc + 1, dr, dc);
        }

        //vertical move
        if (sr + 1 <= dr) {
            downToDest = getMazePaths(sr + 1, sc, dr, dc);
        }

        ArrayList < String > sourceToDest = new ArrayList < > ();

        //src to dest = src to right + right to Dest
        for (int i = 0; i < rightToDest.size(); i++) {
            sourceToDest.add("h" + rightToDest.get(i));
        }

        //src to dest = src to down + down to Dest
        for (int i = 0; i < downToDest.size(); i++) {
            sourceToDest.add("v" + downToDest.get(i));
        }

        return sourceToDest;
    }

}
