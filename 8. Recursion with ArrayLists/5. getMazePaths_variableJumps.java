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

        ArrayList < String > srcToDest = new ArrayList < > ();

        //horizontal moves
        for (int jump = 1; sc + jump <= dc; jump++) {
            ArrayList < String > nbrToDest = getMazePaths(sr, sc + jump, dr, dc);

            //src to dest = src to nbr + nbr to Dest
            for (int i = 0; i < nbrToDest.size(); i++) {
                srcToDest.add("h" + jump + nbrToDest.get(i));
            }
        }

        //vertical moves
        for (int jump = 1; sr + jump <= dr; jump++) {
            ArrayList < String > nbrToDest = getMazePaths(sr + jump, sc, dr, dc);

            //src to dest = src to nbr + nbr to Dest
            for (int i = 0; i < nbrToDest.size(); i++) {
                srcToDest.add("v" + jump + nbrToDest.get(i));
            }
        }

        //diagonal moves
        for (int jump = 1; sr + jump <= dr && sc + jump <= dc; jump++) {
            ArrayList < String > nbrToDest = getMazePaths(sr + jump, sc + jump, dr, dc);

            //src to dest = src to nbr + nbr to Dest
            for (int i = 0; i < nbrToDest.size(); i++) {
                srcToDest.add("d" + jump + nbrToDest.get(i));
            }
        }

        return srcToDest;

    }

}
