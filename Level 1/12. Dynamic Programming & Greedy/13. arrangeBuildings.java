import java.io.*;
import java.util.*;

public class Main{

 public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    long ans = arrangeBuildings(n);
    System.out.println(ans);
 }
 
 public static long arrangeBuildings(int n) {
     int ocb = 1;
     int ocs = 1;
     
     for(int i=2; i <= n;i++) {
         int ncb = ocs;
         int ncs = ocb + ocs;
         
         ocb = ncb;
         ocs = ncs;
     }
     
     int total = ocb + ocs;
     
     long ans = (total * (long)total);
     
     return ans;
     
 }

}