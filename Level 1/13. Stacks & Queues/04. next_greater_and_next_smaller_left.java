import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();

        int[]arr = new int[n];
        for(int i=0;i < n;i++) {
            arr[i]=scn.nextInt();
        }

        int[]ngl = nextGreaterLeft(arr);

        System.out.println("Next Greater elements on left : ");

        for(int i=0;i < n;i++) {
            System.out.print(ngl[i] + " ");
        }

        System.out.println();

        int[]nsl = nextSmallerLeft(arr);

        System.out.println("Next Smaller elements on left : ");

        for(int i=0;i < n;i++) {
            System.out.print(nsl[i] + " ");
        }

        System.out.println();
    }

    public static int[] nextGreaterLeft(int[]arr) {
        int n=arr.length;
        int[]ngl = new int[n];
        
        Stack<Integer>st = new Stack<>();
        st.push(arr[0]);
        
        ngl[0] = -1;
        
        for(int i=1; i < n;i++) {
            while(st.size() > 0 && st.peek() < arr[i]) {
                st.pop();
            }
        
            if(st.size() == 0) {
                ngl[i] = -1;
            }
            else {
                ngl[i] = st.peek();
            }
            
            st.push(arr[i]);
                
        }
        
        return ngl;
    }

    public static int[] nextSmallerLeft(int[]arr) {
        int n=arr.length;
        int[]nsl = new int[n];
        
        Stack<Integer>st = new Stack<>();
        st.push(arr[0]);
        
        nsl[0] = -1;
        
        for(int i=1; i < n;i++) {
            while(st.size() > 0 && st.peek() > arr[i]) {
                st.pop();
            }
        
            if(st.size() == 0) {
                nsl[i] = -1;
            }
            else {
                nsl[i] = st.peek();
            }
            
            st.push(arr[i]);
                
        }
        
        return nsl;
    }
}