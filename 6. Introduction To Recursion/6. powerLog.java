import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int ans = power(x,n);
        System.out.println(ans);
    }
    
    //really smart
    public static int power(int x, int n) {
        if(n == 0) {
            return 1;    
        }
        
        int xrpnb2 = power(x,n/2);
        int xrpn = xrpnb2 * xrpnb2;
        
        if(n % 2 == 1) {
            xrpn = xrpn * x;
        }
        
        return xrpn;
    }
    
    //pseudo smart (worse than power linear)
    /*public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int xrpn = power(x, n / 2) * power(x, n / 2);

        if (n % 2 == 1) {
            xrpn = xrpn * x;
        }

        return xrpn;
    }*/

}
