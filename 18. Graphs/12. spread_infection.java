import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   
   public static class Pair {
       int vtx;
       int t;
       
       Pair() {
           
       }
       
       Pair(int vtx,int t) {
           this.t = t;
           this.vtx = vtx;
       }
   }
   
   public static int bfs(ArrayList<Edge>[]graph,int src,int t) {
      
      boolean[]vis = new boolean[graph.length];
      
      ArrayDeque<Pair>q = new ArrayDeque<>();
      q.add(new Pair(src,1));
      int count = 0;
      
      while(q.size() > 0) {
          //remove
          Pair rem = q.remove();
          
          if(rem.t > t) {
              break;
          }
          
          //mark*
          if(vis[rem.vtx] == true) {
              continue;
          }
          vis[rem.vtx] = true;
          count++;
          
          //add nbr
          for(Edge edge : graph[rem.vtx]) {
              int nbr = edge.nbr;
              
              if(vis[nbr] == false) {
                  q.add(new Pair(nbr,rem.t + 1));
              }
          }
          
      }
      
      return count;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      // write your code here
      int count = bfs(graph,src,t);
      
      System.out.println(count);
   }

}