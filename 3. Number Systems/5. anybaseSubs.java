import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getDifference(b, n1, n2);
        System.out.println(d);
    }

    public static int getDifference(int b, int n1, int n2) {
        // write your code here
        int ans = 0;
        int pow = 1;
        int borrow = 0;

        while (n2 > 0) {
            int ld1 = n1 % 10;
            int ld2 = n2 % 10;
            n1 = n1 / 10;
            n2 = n2 / 10;

            int sub = (ld2 + borrow) - ld1;
            int val = sub;

            if (sub < 0) {
                val = val + b;
                borrow = -1;
            } else {
                borrow = 0;
            }

            ans = ans + val * pow;
            pow = pow * 10;
        }

        return ans;
    }

}
