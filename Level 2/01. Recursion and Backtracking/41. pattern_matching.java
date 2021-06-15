import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, String pattern, int idx, HashMap < Character, String > map) {
        //write your code here
        if (idx == pattern.length()) {
            if (str.length() == 0) {
                HashSet < Character > hs = new HashSet < > ();

                for (int i = 0; i < pattern.length(); i++) {
                    char ch = pattern.charAt(i);

                    if (hs.contains(ch) == false) {
                        System.out.print(ch + " -> " + map.get(ch) + ", ");
                        hs.add(ch);
                    }
                }
                System.out.println(".");
            }
            return;
        }

        char ch = pattern.charAt(idx);

        if (map.containsKey(ch) == true) {
            String lmp = map.get(ch); //last mapping

            if (str.length() < lmp.length()) {
                return;
            }

            String cmp = str.substring(0, lmp.length()); //current mapping of length lmp

            if (lmp.equals(cmp) == false) {
                return;
            }

            String right = str.substring(lmp.length());
            solution(right, pattern, idx + 1, map);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String left = str.substring(0, i + 1);
                String right = str.substring(i + 1);

                map.put(ch, left);
                solution(right, pattern, idx + 1, map);
                map.remove(ch);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String pattern = scn.next();
        HashMap < Character, String > map = new HashMap < > ();
        solution(str, pattern, 0, map);
    }
}