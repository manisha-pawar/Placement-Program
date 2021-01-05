//find inverse of a number

import java.util.*;

public class Main{

    public static void main(String[] args) {
      // write your code here  
      Scanner scn=new Scanner(System.in);
      int n=scn.nextInt();
      
      int fv=0;
      int ans=0;
      
      while(n > 0) {
          fv++;
          int d=n % 10;
          n = n / 10;
          
          ans=ans+fv*(int)Math.pow(10,d-1);
      }
      
      System.out.println(ans);
    }
}
