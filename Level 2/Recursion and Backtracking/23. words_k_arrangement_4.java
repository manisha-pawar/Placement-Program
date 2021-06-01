import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        String ustr = "";
        HashMap < Character, Integer > fmap = new HashMap < > ();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (fmap.containsKey(ch) == true) {
                fmap.put(ch, fmap.get(ch) + 1);
            } else {
                fmap.put(ch, 1);
                ustr += ch;
            }
        }

        words_k_arrangements(ustr, 0, k, fmap, "");
    }

    public static void words_k_arrangements(String ustr, int cs, int k, HashMap < Character, Integer > fmap, String asf) {
        if (cs == k) {
            System.out.println(asf);
            return;
        }


        for (int i = 0; i < ustr.length(); i++) {
            char uch = ustr.charAt(i);

            if (fmap.get(uch) > 0) {
                fmap.put(uch, fmap.get(uch) - 1);
                words_k_arrangements(ustr, cs + 1, k, fmap, asf + uch);
                fmap.put(uch, fmap.get(uch) + 1);
            }
        }
    }

}