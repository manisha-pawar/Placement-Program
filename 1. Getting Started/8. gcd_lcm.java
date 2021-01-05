//find gcd & lcm of two numbers

import java.util.*;
    
public class Main{
    
    public static void main(String[] args) {
      // write your code here  
      Scanner scn=new Scanner(System.in);
      int a=scn.nextInt();
      int b=scn.nextInt();
      
      int oa=a;
      int ob=b;
      
      while(a % b != 0) {
          int temp=a;
          a = b;
          b = temp % b;
      }
      
      int gcd=b;
      int lcm = (oa * ob) / gcd;
      
      System.out.println(gcd);
      System.out.println(lcm);
    }
}
