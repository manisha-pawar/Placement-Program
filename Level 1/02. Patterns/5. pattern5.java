import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int spc=n/2,stc=1;
        
        for(int r=1;r<=n;r++) {
            //print spaces
            for(int i=1;i<=spc;i++) {
                System.out.print("\t");
            }
            //print stars
            for(int i=1;i<=stc;i++) {
                System.out.print("*\t");
            }
            System.out.println();
            
            if(r < (n+1)/2) {
                spc--;
                stc+=2;
            }
            else if(r >= (n+1)/2) {
                spc++;
                stc-=2;
            }
        }
        
        // using relations
        /*for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                if (r + c < (n + 3) / 2) {
                    System.out.print("\t");
                } 
                else if (c - r > (n - 1) / 2) {
                    System.out.print("\t");
                } 
                else if (r + c > (3 * n + 1) / 2) {
                    System.out.print("\t");
                } 
                else if (r - c > (n - 1) / 2) {
                    System.out.print("\t");
                } 
                else {
                    System.out.print("*\t");
                }
            }

            System.out.println();
        }*/

    }

}
