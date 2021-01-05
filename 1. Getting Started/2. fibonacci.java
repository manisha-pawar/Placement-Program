//print fibonacci numbers till n

import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      // write your code here
      Scanner scn=new Scanner(System.in);
      
      int n=scn.nextInt();
      int a=0,b=1;
      
      for(int i=1;i<=n;i++) {
          if(i == 1) {
              System.out.println(a);
          }
          else if(i == 2) {
              System.out.println(b);
          }
          else {
              int c=a+b;
              System.out.println(c);
              a=b;
              b=c;
          }
      }
   }
  }
