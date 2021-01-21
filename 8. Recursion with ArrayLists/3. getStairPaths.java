import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList < String > sp = getStairPaths(n);
        System.out.println(sp);
    }

    public static ArrayList < String > getStairPaths(int n) {
        if (n == 0) {
            ArrayList < String > base = new ArrayList < > ();
            base.add("");
            return base;
        }

        if (n < 0) {
            ArrayList < String > base = new ArrayList < > ();
            return base;
        }

        ArrayList < String > nm1 = getStairPaths(n - 1); //n-1 to 0
        ArrayList < String > nm2 = getStairPaths(n - 2); //n-2 to 0
        ArrayList < String > nm3 = getStairPaths(n - 3); //n-3 to 0

        ArrayList < String > myAns = new ArrayList < > (); // n to 0

        //n to 0 -> n to n-1 + n-1 to 0
        for (int i = 0; i < nm1.size(); i++) {
            myAns.add("1" + nm1.get(i));
        }

        //n to 0 -> n to n-2 + n-2 to 0
        for (int i = 0; i < nm2.size(); i++) {
            myAns.add("2" + nm2.get(i));
        }

        //n to 0 -> n to n-3 + n-3 to 0
        for (int i = 0; i < nm3.size(); i++) {
            myAns.add("3" + nm3.get(i));
        }

        return myAns;
    }

}
