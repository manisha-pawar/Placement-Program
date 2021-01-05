import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int spc=0,stc=n;
        
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
            spc++;
            stc--;
        }

    }
}
