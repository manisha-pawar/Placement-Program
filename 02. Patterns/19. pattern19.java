import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     // write ur code here
     int n=scn.nextInt();
     int mid = (n+1)/2;
     
     for(int r=1;r<=n;r++) {
         for(int c=1;c<=n;c++) {
             if(r == mid || c == mid) {
                 System.out.print("*\t");
             }
             else if(r == 1 && c <= mid) {
                 System.out.print("*\t");
             }
             else if(r == n && c >= mid) {
                 System.out.print("*\t");
             }
             else if(c == 1 && r >= mid) {
                 System.out.print("*\t");
             }
             else if(c == n && r <= mid) {
                 System.out.print("*\t");
             }
             else {
                 System.out.print("\t");
             }
         }
         System.out.println();
     }

 }
}
