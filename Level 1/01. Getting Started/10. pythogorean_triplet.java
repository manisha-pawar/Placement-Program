import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here  
        Scanner scn=new Scanner(System.in);
        int a=scn.nextInt();
        int b=scn.nextInt();
        int c=scn.nextInt();
        
        //assuming a as hypotenuse
        if(a*a == b*b + c*c) {
            System.out.print(true);
        }
        //assuming b as hypotenuse
        else if(b*b == a*a + c*c) {
            System.out.print(true);
        }
        //assuming c as hypotenuse
        else if(c*c == a*a + b*b) {
            System.out.print(true);
        }
        else {
            System.out.print(false);
        }
    }
}
