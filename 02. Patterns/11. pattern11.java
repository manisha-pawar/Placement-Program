import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int val=1;
        
        for(int r=1;r<=n;r++) {
            for(int c=1;c<=r;c++) {
                System.out.print(val+"\t");
                val++;
            }
            System.out.println();
        }

    }
}
