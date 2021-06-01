import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap < Character, Integer > lastOcc = new HashMap < > ();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            lastOcc.put(ch, -1);
        }

        Character[] spots = new Character[k];
        words_k_arrangement(str, 0, lastOcc, 0, k, spots);
    }

    public static void words_k_arrangement(String str, int idx, HashMap < Character, Integer > lastOcc, int ssf, int k, Character[] spots) {
        if (idx == str.length()) {
            if (ssf == k) {
                for (int i = 0; i < spots.length; i++) {
                    System.out.print(spots[i]);
                }
                System.out.println();
            }
            return;
        }

        char ch = str.charAt(idx);
        int loch = lastOcc.get(ch);

        for (int i = loch + 1; i < spots.length; i++) {
            if (spots[i] == null) {
                spots[i] = ch;
                lastOcc.put(ch, i);
                words_k_arrangement(str, idx + 1, lastOcc, ssf + 1, k, spots);
                spots[i] = null;
                lastOcc.put(ch, loch);
            }
        }

        if (loch == -1) {
            words_k_arrangement(str, idx + 1, lastOcc, ssf, k, spots);
        }
    }

}