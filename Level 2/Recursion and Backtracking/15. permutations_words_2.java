import java.io.*;
import java.util.*;

public class Main {

    public static void generateWords(int cc, String str, Character[] spots, HashMap < Character, Integer > lastOccurence) {
        if (cc == str.length()) {
            for (int i = 0; i < spots.length; i++) {
                System.out.print(spots[i]);
            }
            System.out.println();
            return;
        }

        char ch = str.charAt(cc);
        int loch = lastOccurence.get(ch); //last occurence of ch

        for (int i = loch + 1; i < spots.length; i++) {
            if (spots[i] == null) {
                spots[i] = ch;
                lastOccurence.put(ch, i);
                generateWords(cc + 1, str, spots, lastOccurence);
                spots[i] = null;
                lastOccurence.put(ch, loch);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Character[] spots = new Character[str.length()];
        HashMap < Character, Integer > lastOccurence = new HashMap < > ();
        for (char ch: str.toCharArray()) {
            lastOccurence.put(ch, -1);
        }

        generateWords(0, str, spots, lastOccurence);
    }

}