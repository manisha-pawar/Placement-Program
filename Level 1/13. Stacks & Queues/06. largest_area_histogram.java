import java.io.*;
import java.util.*;

public class Main{
  

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
        a[i] = Integer.parseInt(br.readLine());
        }

        // code
        
        int ans = largestAreaHist(a);
        System.out.println(ans);
    }
 
    public static int largestAreaHist(int[]arr) {
        int[]nsl = nextSmallerLeft(arr);
        int[]nsr = nextSmallerRight(arr);
        
        int max = 0;
        
        for(int i=0;i < arr.length;i++) {
            int area = arr[i] * (nsr[i] - nsl[i] - 1);
            
            if(area > max) {
                max = area;
            }
        }
        
        return max;
    } 
    
    public static int[] nextSmallerLeft(int[]arr) {
        int n = arr.length;
        int[]nsl = new int[n];
        
        Stack<Integer>st = new Stack<>();
        
        nsl[0] = -1;
        st.push(0);
        
        for(int i=1; i < n;i++) {
            while(st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            
            if(st.size() == 0) {
                nsl[i] = -1;
            }
            else {
                nsl[i] = st.peek();
            }
            st.push(i);
        }
        
        return nsl;
    }
 
    public static int[] nextSmallerRight(int[]arr) {
        int n = arr.length;
        int[]nsr = new int[n];
        
        nsr[n-1] = n;
        Stack<Integer>st = new Stack<>();
        st.push(n-1);
        
        for(int i=n-2; i >= 0;i--) {
            while(st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            
            if(st.size() == 0) {
                nsr[i] = n;
            }
            else {
                nsr[i] = st.peek();
            }
            
            st.push(i);
        }
        
        return nsr;
    }
 
 
 
 
}