import java.io.*;
import java.util.*;

public class Main {

    public static void generatepw(int cs, int ts, HashMap < Character, Integer > fmap, Character oddfc, String asf) {
        if (cs == ts) {
            String rasf = "";
            for (int i = asf.length() - 1; i >= 0; i--) {
                rasf += asf.charAt(i);
            }

            if (oddfc == null) {
                System.out.println(asf + rasf);
            } else {
                System.out.println(asf + oddfc + rasf);
            }
            return;
        }

        for (char uch: fmap.keySet()) {
            if (fmap.get(uch) > 0) {
                fmap.put(uch, fmap.get(uch) - 1);
                generatepw(cs + 1, ts, fmap, oddfc, asf + uch);
                fmap.put(uch, fmap.get(uch) + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        HashMap < Character, Integer > fmap = new HashMap < > ();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (fmap.containsKey(ch) == true) {
                fmap.put(ch, fmap.get(ch) + 1);
            } else {
                fmap.put(ch, 1);
            }
        }

        Character oddfc = null;
        int oddf = 0;
        int len = 0;

        for (char key: fmap.keySet()) {
            int val = fmap.get(key);

            if (val % 2 != 0) {
                oddfc = key;
                oddf++;
            }

            fmap.put(key, val / 2);
            len += (val / 2);
        }

        if (oddf > 1) {
            System.out.println("-1");
            return;
        }

        generatepw(0, len, fmap, oddfc, "");

    }

}