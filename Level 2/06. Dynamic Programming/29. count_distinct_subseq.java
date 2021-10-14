import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        //write your code here

        System.out.println(cds(str));

    }

    public static long cds(String str) {
        HashMap < Character, Integer > map = new HashMap < > (); //last occ

        str = "." + str;

        long[] dp = new long[str.length()];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            char ch = str.charAt(i);

            int lo = map.getOrDefault(ch, -1);
            long sc = (lo == -1) ? 0 : dp[lo - 1];

            dp[i] = 2 * dp[i - 1] - sc;

            map.put(ch, i);
        }

        return dp[dp.length - 1] - 1; //due to non-empty subseq

    }
}