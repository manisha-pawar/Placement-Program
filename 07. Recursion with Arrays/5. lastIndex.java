import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[]arr=new int[n];
        
        for(int i=0;i<n;i++) {
            arr[i]=scn.nextInt();
        }
        
        int key = scn.nextInt();
        
        int li = lastIndex(arr,0,key);
        System.out.println(li);
    }

    public static int lastIndex(int[] arr, int idx, int x) {
        if(idx == arr.length) {
            return -1;
        }
        
        int li = lastIndex(arr,idx+1,x);
        
        if(li != -1) {
            return li;
        }
        else {
            if(arr[idx] == x) {
                return idx;
            }
            else {
                return -1;
            }
        }
    }

}
