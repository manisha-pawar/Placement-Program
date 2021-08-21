import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int noofpairs_src_des = scn.nextInt();
        HashMap < String, String > map = new HashMap < > ();
        for (int i = 0; i < noofpairs_src_des; i++) {
            String s1 = scn.next();
            String s2 = scn.next();
            map.put(s1, s2);
        }

        //write your code here

        HashMap < String, Boolean > stp = new HashMap < > (); //start point


        for (String src: map.keySet()) {
            String dest = map.get(src);

            if (stp.containsKey(src) == false) {
                stp.put(src, true);
            }
            stp.put(dest, false);
        }

        String sp = "";
        for (String src: stp.keySet()) {
            if (stp.get(src) == true) {
                sp = src;
                break;
            }
        }

        String temp = sp; 
        while (map.containsKey(temp) == true) {
            System.out.print(temp + " -> ");
            temp = map.get(temp);
        }

        System.out.println(temp + ".");

    }
}