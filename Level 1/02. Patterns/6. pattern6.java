import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int spc=1,stc=(n+1)/2;
        
        for(int r=1;r<=n;r++) {
            //print left stars
            for(int i=1;i<=stc;i++) {
                System.out.print("*\t");
            }
            //print spaces
            for(int i=1;i<=spc;i++) {
                System.out.print("\t");
            }
            //print right stars
            for(int i=1;i<=stc;i++) {
                System.out.print("*\t");
            }
            
            System.out.println();
            
            if(r < (n+1)/2) {
                spc+=2;
                stc--;
            }
            else if(r >= (n+1)/2) {
                spc-=2;
                stc++;
            }
        }

    }
}
