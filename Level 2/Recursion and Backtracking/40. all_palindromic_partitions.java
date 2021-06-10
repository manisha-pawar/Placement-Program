import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);

            if (isPalindromic(left) == true) {
                String right = str.substring(i + 1);
                solution(right, asf + "(" + left + ") ");
            }
        }

    }

    public static boolean isPalindromic(String str) {
        int lo = 0;
        int hi = str.length() - 1;

        while (lo < hi) {
            if (str.charAt(lo) != str.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, "");
    }

}