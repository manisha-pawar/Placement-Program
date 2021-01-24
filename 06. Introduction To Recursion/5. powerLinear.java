import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int x=scn.nextInt();
        int n=scn.nextInt();
        int ans = power(x,n); // expectation -> x^n
        System.out.println(ans);
    }

    public static int power(int x, int n) {
       if(n == 0) {
           //x^0
           return 1;
       }
       
       int xrpnm1 = power(x,n-1); // faith
       int xrpn = x * xrpnm1;
       
       return xrpn;
    }

}
