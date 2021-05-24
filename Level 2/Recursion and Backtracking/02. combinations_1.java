import java.io.*;
import java.util.*;

public class Main {

    public static void combinations(int cb, int tb, int itpsf, int ts, String asf) {
        if (cb > tb) {
            if (itpsf == ts) {
                System.out.println(asf);
            }
            return;
        }

        //item is placed at cb
        combinations(cb + 1, tb, itpsf + 1, ts, asf + "i");

        //item is not placed at cb
        combinations(cb + 1, tb, itpsf, ts, asf + "-");

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(1, nboxes, 0, ritems, "");
    }

}