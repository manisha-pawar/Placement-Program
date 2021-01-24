import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     // write ur code here
     int n=scn.nextInt();
     int spc=2*n-3;
     
     for(int r=1;r<=n;r++) {
         //print left numbers
         int lst=1;
         int lc=r;
         
         for(int i=1;i<=lc;i++) {
             System.out.print(lst+"\t");
             lst++;
         }
         
         //print spaces
         for(int i=1;i<=spc;i++) {
             System.out.print("\t");
         }
         
         //print right number
         int rst = (r == n) ? n-1 : r;
         int rc=rst;
         
         for(int i=1;i<=rc;i++) {
             System.out.print(rst+"\t");
             rst--;
         }
         
         System.out.println();
         spc-=2;
         
     }

 }
}
