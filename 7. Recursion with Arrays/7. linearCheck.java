import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        
        int[]x=new int[n];
        int[]y=new int[n];
        
        for(int i=0;i < n;i++) {
            x[i]=scn.nextInt();
            y[i]=scn.nextInt();
        }
        
        //state 0(VX,HX) 1(V) 2(H) 3(V,H)
        int ans = linearCheck(x,y,0);
        if(ans != 0) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
    
    public static int linearCheck(int[]x,int[]y,int idx) {
        if(idx == x.length-1) {
            return 3;
        }
        
        int state = linearCheck(x,y,idx+1);
        if(state == 0) {
            //no horizontal, no vertical
            return 0;
        }
        else if(state == 1) {
            //vertical
            if(x[idx] == x[idx+1]) {
                return 1;
            }
            else {
                return 0;
            }
        }
        else if(state == 2) {
            //horizontal
            if(y[idx] == y[idx+1]) {
                return 2;
            }
            else {
                return 0;
            }
        }
        else if(state == 3) {
            //both horizontal & vertical
            if(x[idx] == x[idx+1] && y[idx] == y[idx+1]) {
                return 3;
            }
            else if(x[idx] == x[idx+1]) {
                return 1;
            }
            else if(y[idx] == y[idx+1]) {
                return 2;
            }
            else {
                return 0;
            }
        }
        else {
            return -1;
        }
        
    }
}
