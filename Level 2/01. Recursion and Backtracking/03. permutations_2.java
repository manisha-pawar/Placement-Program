import java.io.*;
import java.util.*;

public class Main {

    public static void permutations(int cb, int tb, boolean[] items, int itpsf, int ts, String asf) {
        if (cb > tb) {
            if (itpsf == ts) {
                System.out.println(asf);
            }
            return;
        }

        //yes calls -> which item to select 
        for (int it = 0; it < items.length; it++) {
            if (items[it] == false) {
                items[it] = true;
                permutations(cb + 1, tb, items, itpsf + 1, ts, asf + (it + 1));
                items[it] = false;
            }
        }

        //no call
        permutations(cb + 1, tb, items, itpsf, ts, asf + 0);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(1, nboxes, new boolean[ritems], 0, ritems, "");
    }

}