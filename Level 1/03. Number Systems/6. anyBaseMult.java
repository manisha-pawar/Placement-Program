import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getProduct(b, n1, n2);
        System.out.println(d);
    }

    public static int getProduct(int b, int n1, int n2) {
        // write your code here
        int ans = 0;
        int pow = 1;

        while (n2 > 0) {
            int d = n2 % 10;
            n2 = n2 / 10;

            int subAns = singleDigitMult(n1, d, b);

            ans = anyBaseAddition(ans, subAns * pow, b);
            pow = pow * 10;
        }

        return ans;
    }

    public static int singleDigitMult(int n, int d, int b) {
        int ans = 0;
        int pow = 1;
        int carry = 0;

        while (n > 0 || carry > 0) {
            int ld1 = n % 10;
            n = n / 10;
            int ld2 = d;

            int mult = (ld1 * ld2) + carry;
            int val = mult % b;
            carry = mult / b;

            ans = ans + val * pow;
            pow = pow * 10;
        }

        return ans;
    }

    public static int anyBaseAddition(int n1, int n2, int b) {
        int ans = 0;
        int pow = 1;
        int carry = 0;

        while (n1 > 0 || n2 > 0 || carry > 0) {
            int ld1 = n1 % 10;
            int ld2 = n2 % 10;
            n1 = n1 / 10;
            n2 = n2 / 10;

            int sum = ld1 + ld2 + carry;
            int val = sum % b;
            carry = sum / b;

            ans = ans + val * pow;
            pow = pow * 10;
        }

        return ans;
    }

}
