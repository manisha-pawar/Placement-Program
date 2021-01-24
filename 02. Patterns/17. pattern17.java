import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int stc=1;
       
        for(int r=1;r<=n;r++) {
           //left stars (only for mid row)
           int lst = (r == (n+1)/2) ? n/2 : 0;
           for(int i=1;i<=lst;i++) {
               System.out.print("*\t");
           }
           
           //spaces
           int spc = (r == (n+1)/2) ? 0 : n/2;
           for(int i=1;i<=spc;i++) {
               System.out.print("\t");
           }
           
           //right stars;
           for(int i=1;i<=stc;i++) {
               System.out.print("*\t");
           }
           
           System.out.println();
           
           if(r < (n+1)/2) {
               stc++;
           }
           else {
               stc--;
           }
           
        }

    }
}
