import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      // write your code here
      
      kLargest(arr,k);
      
    }
    
    public static void kLargest(int[]arr,int k) {
        
        PriorityQueue<Integer>pq = new PriorityQueue<>(); //smaller value has higher priority
        
        
        for(int i=0; i < arr.length;i++) {
            if(pq.size() < k) {
                pq.add(arr[i]);
            }
            else {
                if(pq.peek() < arr[i]) {
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        
        //print ans
        while(pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }

}