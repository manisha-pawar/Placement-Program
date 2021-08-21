import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] words = br.readLine().split(" ");

        System.out.println(alienOrder(words));
    }

    public static String alienOrder(String[] words) {
        HashMap < Character, ArrayList < Character >> graph = new HashMap < > ();


        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (graph.containsKey(ch) == false) {
                    graph.put(ch, new ArrayList < > ());
                }
            }
        }

        for (int k = 0; k < words.length - 1; k++) {
            String w1 = words[k];
            String w2 = words[k + 1];

            int i = 0, j = 0;

            while (i < w1.length() && j < w2.length()) {
                char ch1 = w1.charAt(i);
                char ch2 = w2.charAt(j);

                if (ch1 != ch2) {
                    graph.get(ch1).add(ch2);
                    graph.put(ch1, graph.get(ch1));
                    break;
                }

                i++;
                j++;
            }

            if (i < w1.length() && j == w2.length()) {
                return ""; //invalid order of words
            }

        }


        //topological sort using kahn's
        HashMap < Character, Integer > indeg = new HashMap < > ();

        for (char v: graph.keySet()) {
            indeg.put(v, 0);
        }

        for (char v: graph.keySet()) {
            for (char nbr: graph.get(v)) {
                indeg.put(nbr, indeg.get(nbr) + 1);
            }
        }


        ArrayDeque < Character > q = new ArrayDeque < > ();

        for (char v: indeg.keySet()) {
            if (indeg.get(v) == 0) {
                q.add(v);
            }
        }

        String order = "";
        while (q.size() > 0) {
            char rem = q.remove();

            order += rem;

            for (char nbr: graph.get(rem)) {
                indeg.put(nbr, indeg.get(nbr) - 1);

                if (indeg.get(nbr) == 0) {
                    q.add(nbr);
                }
            }
        }

        if (order.length() == graph.size()) {
            return order;
        } else {
            return "";
        }

    }
}