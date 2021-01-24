import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList < String > ss = gss(str);
        System.out.println(ss);
    }

    public static ArrayList < String > gss(String str) {
        if (str.length() == 0) {
            ArrayList < String > base = new ArrayList < > ();
            base.add("");
            return base;
        }

        char ch = str.charAt(0); // a
        String rstr = str.substring(1); //bc

        ArrayList < String > recres = gss(rstr); // [,c,b,bc]
        ArrayList < String > myres = new ArrayList < > ();

        //a choice-> no
        for (int i = 0; i < recres.size(); i++) {
            myres.add(recres.get(i));
        }

        //a choice -> yes
        for (int i = 0; i < recres.size(); i++) {
            myres.add(ch + recres.get(i));
        }

        return myres;

    }

}
