import java.io.*;
import java.util.*;

public class Main {
    
   public static class Pair implements Comparable<Pair>{
       int val;
       int idx;
       int li;
       
       Pair() {
           
       }
       
       Pair(int val,int idx,int li) {
           this.val = val;
           this.idx = idx;
           this.li = li;
       }
       
       //-ve value -> this < o
       //+ve value -> this > o
       //0 value -> this == o
       
       public int compareTo(Pair o) {
           return this.val - o.val;
       }
       
   }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      // write your code here
      PriorityQueue<Pair>pq = new PriorityQueue<>(); //smaller value has higher priority
      
      //fill pq with each list's first element
      for(int i=0; i < lists.size(); i++) {
          Pair p = new Pair(lists.get(i).get(0),0,i);
          pq.add(p);
      }
      
      while(pq.size() > 0) {
          Pair top = pq.remove();
          rv.add(top.val);
          
          int nli = top.li;
          int nidx = top.idx + 1;
          
          if(nidx < lists.get(nli).size()) {
              int nval = lists.get(nli).get(nidx);
              
              Pair p =  new Pair(nval,nidx,nli);
              pq.add(p);
          }
      }

      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}