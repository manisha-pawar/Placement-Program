import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        printEncodings(str, "");
    }

    public static void printEncodings(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        char ch = str.charAt(0);

        if (ch == '0') {
            return;
        }

        char encode = (char)(ch - '0' + 'a' - 1); // 1->a,2->b...9->i
        String remstr = str.substring(1);

        printEncodings(remstr, asf + encode);

        if (str.length() >= 2) {
            String s = str.substring(0, 2);
            String remStr = str.substring(2);

            int val = Integer.parseInt(s); //"23" = 23
            if (val <= 26) {
                char Encode = (char)(val + 'a' - 1); //10->j,11->k....26->z
                printEncodings(remStr, asf + Encode);
            }
        }

    }

}
