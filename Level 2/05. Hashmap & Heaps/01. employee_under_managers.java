import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashMap < String, ArrayList < String >> GT = new HashMap < > ();
        String ceo = "";

        while (n-- > 0) {
            String emp = scn.next();
            String man = scn.next();

            if (emp.equals(man) == true) {
                ceo = man;
                if (GT.containsKey(man) == false) {
                    GT.put(emp, new ArrayList < > ());
                }
                continue;
            }

            if (GT.containsKey(man) == false) {
                ArrayList < String > list = new ArrayList < > ();
                list.add(emp);
                GT.put(man, list);
            } else {
                ArrayList < String > list = GT.get(man);
                list.add(emp);
                GT.put(man, list);
            }


            if (GT.containsKey(emp) == false) {
                GT.put(emp, new ArrayList < > ());
            }
        }

        HashMap < String, Integer > ans = new HashMap < > ();
        size(ceo, GT, ans);

        for (String man: ans.keySet()) {
            int empc = ans.get(man);
            System.out.println(man + " " + empc);
        }
    }



    public static int size(String root, HashMap < String, ArrayList < String >> GT, HashMap < String, Integer > ans) {

        int ts = 0;

        for (String child: GT.get(root)) {
            ts += size(child, GT, ans);
        }

        ans.put(root, ts);
        return ts + 1;
    }

}