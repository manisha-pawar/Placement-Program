import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     // write ur code here
     int n=scn.nextInt();
     int lsp=n/2,msp=-1;
     
     for(int r=1;r<=n;r++) {
         //print left spaces
         for(int i=1;i<=lsp;i++) {
             System.out.print("\t");
         }
         
         //left star
         System.out.print("*\t");
         
         //print middle spaces
         for(int i=1;i<=msp;i++) {
             System.out.print("\t");
         }
         
         //right star
         if(r != 1 && r != n) {
             System.out.print("*\t");
         }
         
         System.out.println();
         
         if(r < (n+1)/2) {
             lsp--;
             msp+=2;
         }
         else if(r >= (n+1)/2) {
             lsp++;
             msp-=2;
         }
     }

 }
}
