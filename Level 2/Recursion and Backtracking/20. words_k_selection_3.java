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

        words_k_selection(ustr, 0, unique, "", k);
    }

    public static void words_k_selection(String ustr, int idx, HashMap < Character, Integer > fmap, String asf, int k) {
        if (idx == ustr.length()) {
            if (asf.length() == k) {
                System.out.println(asf);
            }
            return;
        }

        char ch = ustr.charAt(idx);
        int freqch = fmap.get(ch);


        for (int c = freqch; c >= 0; c--) {
            String sasf = "";

            for (int i = 1; i <= c; i++) {
                sasf += ch;
            }

            words_k_selection(ustr, idx + 1, fmap, asf + sasf, k);
        }
    }

}