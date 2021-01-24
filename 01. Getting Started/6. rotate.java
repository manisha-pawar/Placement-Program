//rotate a number

import java.util.*;
   
   public class Main{
   
   public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int k=scn.nextInt();
        
        int nod=0;
        int temp=n;
        
        while(temp > 0) {
            nod++;
            temp=temp/10;
        }
        
        k = k % nod;
        
        if(k < 0) {
            k=k + nod;
        }
        
        int pow = (int)Math.pow(10,k);
        int left=n / pow;
        int right=n % pow;
        
        int shift = (int)Math.pow(10,nod-k);
        int ans=right*shift+left;
        
        System.out.println(ans);
    }
    
   }
