import java.io.*;
import java.util.*;

public class Main{
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
        sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
        a[i] = Integer.parseInt(br.readLine());
        }

        int[] nge = solve2(a);
        display(nge);
    }

    public static int[] solve(int[] arr){
        // solve
        int n=arr.length;
        int[]ngeor = new int[n];
        
        Stack<Integer>st = new Stack<>();
        st.push(arr[n-1]);
        
        ngeor[n-1] = -1;
        
        for(int i=n-2; i >= 0;i--) {
            while(st.size() > 0 && st.peek() < arr[i]) {
                st.pop();
            }
        
            if(st.size() == 0) {
                ngeor[i] = -1;
            }
            else {
                ngeor[i] = st.peek();
            }
            
            st.push(arr[i]);
        
         }
   
         return ngeor;
    }
 
    public static int[] solve2(int[]arr) {
        //ngeor -> idx based (values, distance)
        
        Stack<Integer>st = new Stack<>();
        int n=arr.length;
        int[]ngeor = new int[n];
        
        st.push(n-1);
        ngeor[n-1] = -1;
        
        for(int i=n-2;i >= 0;i--) {
            while(st.size() > 0 && arr[i] > arr[st.peek()]) {
                st.pop();
            }
            
            if(st.size() == 0) {
                ngeor[i] = -1;
            }
            else {
                ngeor[i] = arr[st.peek()];
            }
            
            st.push(i);
        }
        
        return ngeor;
        
    }

}