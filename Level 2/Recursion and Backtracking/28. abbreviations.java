import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, int pos, String asf, int count) {
        if (pos == str.length()) {
            if (count == 0) {
                System.out.println(asf);
            } else {
                System.out.println(asf + count);
            }
            return;
        }

        char ch = str.charAt(pos);

        //yes call
        if (count > 0) {
            solution(str, pos + 1, asf + count + ch, 0);
        } else {
            solution(str, pos + 1, asf + ch, 0);
        }

        //no call
        solution(str, pos + 1, asf, count + 1);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, 0, "", 0);
    }


}