//print digits of a number from left to right

import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
          Scanner scn=new Scanner(System.in);
          long n=scn.nextLong();
          
          long pow = 1;
          long temp = n;
          
          while(temp > 0) {
              pow=pow*10;
              temp=temp/10;
          }
          
          pow = pow/10;
          
          while(pow > 0) {
              int d=(int)(n / pow);
              System.out.println(d);
              n= n % pow;
              pow=pow/10;
          }
          
        }
    }
