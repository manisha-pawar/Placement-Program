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

        Character[] spots = new Character[k];

        words_k_arrangement(ustr, 0, 0, spots);
    }

    public static void words_k_arrangement(String ustr, int idx, int ssf, Character[] spots) {

        if (idx == ustr.length()) {
            if (ssf == spots.length) {
                for (int i = 0; i < spots.length; i++) {
                    System.out.print(spots[i]);
                }
                System.out.println();
            }
            return;
        }

        char ch = ustr.charAt(idx);

        for (int i = 0; i < spots.length; i++) {
            if (spots[i] == null) {
                spots[i] = ch;
                words_k_arrangement(ustr, idx + 1, ssf + 1, spots);
                spots[i] = null;
            }
        }

        words_k_arrangement(ustr, idx + 1, ssf, spots);
    }


}