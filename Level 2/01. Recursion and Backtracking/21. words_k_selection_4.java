import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap < Character, Integer > unique = new HashMap < > ();
        String ustr = "";
        for (char ch: str.toCharArray()) {
            if (unique.containsKey(ch) == false) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }

        words_k_selection(ustr, unique, 0, k, "", 0);


    }

    public static void words_k_selection(String ustr, HashMap < Character, Integer > fmap, int cs, int k, String asf, int lci) {
        if (cs == k) {
            System.out.println(asf);
            return;
        }

        for (int i = lci; i < ustr.length(); i++) {
            char uch = ustr.charAt(i);
            if (fmap.get(uch) > 0) {
                fmap.put(uch, fmap.get(uch) - 1);
                words_k_selection(ustr, fmap, cs + 1, k, asf + uch, i);
                fmap.put(uch, fmap.get(uch) + 1);
            }
        }
    }

}