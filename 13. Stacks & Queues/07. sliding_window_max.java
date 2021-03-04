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
        int k = Integer.parseInt(br.readLine());

        // code
        
        slidingWindowMax(a,k);
    }
 
    public static void slidingWindowMax(int[]arr,int k) {
        int[]ngr = nextGreaterRight(arr);
        int n=arr.length;
        
        for(int i=0; i <= n-k;i++) {
            int j = i;
            
            while(ngr[j] < i+k) {
                j = ngr[j];
            }
            
            System.out.println(arr[j]);
        }
    }
 
    public static int[] nextGreaterRight(int[]arr) {
        int n=arr.length;
        int[]ngr = new int[n];
        
        Stack<Integer>st = new Stack<>();
        ngr[n-1]=n;
        st.push(n-1);
        
        for(int i=n-2;i >= 0;i--) {
            while(st.size() > 0 && arr[i] > arr[st.peek()]) {
                st.pop();
            }
            
            if(st.size() == 0) {
                ngr[i] = n;
            }
            else {
                ngr[i] = st.peek();
            }
            
            st.push(i);
        }
        
        return ngr;
    }
}