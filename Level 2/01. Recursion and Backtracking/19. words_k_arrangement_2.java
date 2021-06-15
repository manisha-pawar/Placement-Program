import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashSet < Character > unique = new HashSet < > ();
        String ustr = "";
        for (char ch: str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }

        HashSet < Character > usedCH = new HashSet < > ();
        word_k_arrangement(ustr, 0, k, usedCH, "");

    }
    
    public static void word_k_arrangement(String ustr, int cs, int ts, HashSet < Character > usedCH, String asf) {
        if (cs == ts) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < ustr.length(); i++) {
            char uch = ustr.charAt(i);

            if (usedCH.contains(uch) == false) {
                usedCH.add(uch);
                word_k_arrangement(ustr, cs + 1, ts, usedCH, asf + uch);
                usedCH.remove(uch);
            }
        }
    }

}