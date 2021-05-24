import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        
        Stack<Integer>st = new Stack<>();
        
        int n=arr.length;
        
        for(int i=0;i < n;i++) {
            st.push(i);
        }
        
        while(st.size() >= 2) {
            int a = st.pop();
            int b = st.pop();
            
            if(arr[a][b] == 1) {
                //a can't be a celebrity
                st.push(b);
            }
            else {
                //b can't be a celebrity
                st.push(a);
            }
        }
        
        int pc = st.peek();
        boolean ans = true;
        
        //column check
        for(int i=0; i < n;i++) {
            if(i != pc && arr[i][pc] == 0) {
                ans = false;
                break;
            }
        }
        
        //row check
        for(int i=0; i < n;i++) {
            if(i != pc && arr[pc][i] == 1) {
                ans = false;
                break;
            }
        }
        
        if(ans == true) {
            System.out.println(pc);
        }
        else {
            System.out.println("none");
        }
        
        
    }

}