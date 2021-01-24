//is a number prime

import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
  
       // write ur code here
       int t=scn.nextInt();
       
       for(int i=1;i<=t;i++) {
           int num=scn.nextInt();
           boolean isPrime=true;
           for(int div=2;div*div <= num;div++) {
               if(num % div == 0) {
                   isPrime=false;
                   break;
               }
           }
           
           if(isPrime == true) {
               System.out.println("prime");
           }
           else {
               System.out.println("not prime");
           }
       }
  
   }
  }
