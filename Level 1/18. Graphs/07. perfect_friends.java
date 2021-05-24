import java.io.*;
import java.util.*;

public class Main {
   
   public static int perfectFriends(ArrayList<Integer>[]graph) {
       
       boolean[]vis = new boolean[graph.length];
       ArrayList<Integer>ccs = new ArrayList<>(); // connect component size
       
       for(int v=0; v < graph.length;v++) {
           if(vis[v] == false) {
               ArrayList<Integer>scc = new ArrayList<>();
               dfs(graph,v,scc,vis);
               ccs.add(scc.size());
           }
       }
       
       int count = 0;
       
       for(int i=0; i < ccs.size();i++) {
           for(int j=i+1; j < ccs.size();j++) {
               int s1 = ccs.get(i);
               int s2 = ccs.get(j);
               
               count += s1*s2;
           }
       }
       
       return count;
   }
   
   public static void dfs(ArrayList<Integer>[]graph,int src,ArrayList<Integer>list,boolean[]vis) {
       
       list.add(src);
       
       vis[src] = true;
       
       for(int nbr : graph[src]) {
           if(vis[nbr] == false) {
               dfs(graph,nbr,list,vis);
           }
       }
   }
   
   public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner(System.in);

      int n = scn.nextInt();
      int k = scn.nextInt();
      
      // write your code here
      ArrayList<Integer>[]graph = new ArrayList[n];
      
      for(int i=0; i < graph.length;i++) {
          graph[i] = new ArrayList<>();
      }
      
      while(k-- > 0) {
          int v1 = scn.nextInt();
          int v2 = scn.nextInt();
          
          graph[v1].add(v2);
          graph[v2].add(v1);
      }
      
      int ways = perfectFriends(graph);
      System.out.println(ways);
      
   }

}