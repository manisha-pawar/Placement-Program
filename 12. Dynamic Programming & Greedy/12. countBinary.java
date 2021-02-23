import java.io.*;
import java.util.*;

public class Main{

 public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    
    System.out.println(cbs(n));
 }
 
 public static int cbs(int n) {
    
    int oczero = 1; // count of binary string of length one ending at 0
    int ocone = 1; // count of binary string of length one ending at 1
    
    for(int i=2; i <= n;i++) {
        int nczero = ocone;
        int ncone =  ocone + oczero;
        
        oczero = nczero;
        ocone = ncone;
    }
    
    return oczero + ocone;
 }

}