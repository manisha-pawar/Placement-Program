//count digits in a number

import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        
        int nod=0;
        
        while(n != 0) {
            n=n/10;
            nod++;
        }
        
        System.out.println(nod);
   }
  }
