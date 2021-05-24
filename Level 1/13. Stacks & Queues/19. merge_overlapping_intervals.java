import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static class Pair implements Comparable<Pair>{
        int st;
        int et;
        
        Pair() {
            
        }
        Pair(int st,int et) {
            this.st = st;
            this.et = et;
        }
        //+ve val -> this > o
        //0 val -> this == o
        //-ve val -> this < o
        public int compareTo(Pair o) {
            return this.st - o.st;
        }
    }
    
    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        int n = arr.length;
        
        Pair[]intervals = new Pair[n];
        
        for(int i=0; i < arr.length;i++) {
            int ist = arr[i][0];
            int iet = arr[i][1];
            
            Pair p = new Pair(ist,iet);
            intervals[i] = p;
        }
        
        Arrays.sort(intervals);
        
        Stack<Pair>st = new Stack<>();
        
        st.push(intervals[0]);
        
        for(int i=1;i < n;i++) {
            Pair top = st.peek();
            Pair curr = intervals[i];
            
            if(top.et >= curr.st) {
                top.et = Math.max(top.et,curr.et);
            }
            else {
                st.push(curr);
            }
        }
        
        //print on the basis of increasing start time
        Stack<Pair>ans = new Stack<>();
        
        while(st.size()!=0) {
            ans.push(st.pop());
        }
        
        while(ans.size()!=0) {
            Pair p = ans.pop();
            System.out.println(p.st + " " + p.et);
        }
        
        
    }

}