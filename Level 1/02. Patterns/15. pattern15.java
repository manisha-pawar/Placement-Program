import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int spc=n/2;
        int valc=1;
        int rst=1;
        
        for(int r=1;r<=n;r++) {
            //print spaces
            for(int i=1;i<=spc;i++) {
                System.out.print("\t");
            }
            //print content/values
            int val=rst;
            int mid=(valc+1)/2;
            for(int i=1;i<=valc;i++) {
                System.out.print(val+"\t");
                
                if(i < mid) {
                    val++;
                }
                else if(i >= mid) {
                    val--;
                }
            }
            
            System.out.println();
            if(r < (n+1)/2) {
                spc--;
                valc+=2;
                rst++;
            }
            else {
                spc++;
                valc-=2;
                rst--;
            }
        }

    }
}
