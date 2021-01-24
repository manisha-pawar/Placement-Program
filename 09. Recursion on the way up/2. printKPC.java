import java.io.*;
import java.util.*;

public class Main {

    static String[] codes = {
        ".;",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tu",
        "vwx",
        "yz"
    };

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        printKPC(str, "");
    }

    public static void printKPC(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0); //5
        String remstr = str.substring(1); // 79

        String mycode = codes[ch - '0']; // mno

        for (int i = 0; i < mycode.length(); i++) {
            printKPC(remstr, ans + mycode.charAt(i));
        }

    }

}
