import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int spc=n-1,stc=1;
        
        for(int r=1;r<=n;r++) {
            //printing spaces
            for(int i=1;i<=spc;i++) {
                System.out.print("\t");
            }
            //printing stars
            for(int i=1;i<=stc;i++) {
                System.out.print("*\t");
            }
            
            System.out.println();
            spc--;
            stc++;
        }

    }
}
