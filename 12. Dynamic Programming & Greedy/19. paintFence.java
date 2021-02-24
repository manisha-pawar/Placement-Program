import java.util.*;
 
 public class Main {
 
 	 public static void main(String[] args) {
         // TODO Auto-generated method stub
         Scanner scn= new Scanner(System.in);
         int a=scn.nextInt();
         int b=scn.nextInt();
 	 	 System.out.println(CountWays(a,b));
 	 }
 	 // -----------------------------------------------------
 	 // This is a functional problem. Only this function has to be written.
 	 // This function takes as input 2 integers
 	 // It should return the required output
 
 	 public static int CountWays(int n, int k) {
 	 	 //Write your code here
 	 	 int sc = 0;
 	 	 int dc = 0;
 	 	 
 	 	 for(int i=2; i <= n;i++) {
 	 	     if(i == 2) {
 	 	         sc = k;
 	 	         dc = k*(k-1);
 	 	     }
 	 	     else {
 	 	         int total = sc + dc;
 	 	         sc = dc;
 	 	         dc = total * (k-1);
 	 	     }
 	 	 }
 	 	 
 	 	 return sc + dc;
 	 }
 }