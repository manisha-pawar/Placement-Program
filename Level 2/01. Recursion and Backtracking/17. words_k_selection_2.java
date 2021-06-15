import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();

        HashSet < Character > hs = new HashSet < > ();
        String ustr = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (hs.contains(ch) == false) {
                hs.add(ch);
                ustr += ch;
            }
        }

        word_k_selection(ustr, 0, k, "", -1);
    }

    public static void word_k_selection(String ustr, int cs, int ts, String asf, int lci) {
        if (cs == ts) {
            System.out.println(asf);
            return;
        }

        for (int i = lci + 1; i < ustr.length(); i++) {
            char uch = ustr.charAt(i);
            word_k_selection(ustr, cs + 1, ts, asf + uch, i);
        }
    }

}