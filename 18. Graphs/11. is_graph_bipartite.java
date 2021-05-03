import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   public static class Pair {
       int vtx;
       int set;
       
       Pair(int vtx,int set) {
           this.vtx = vtx;
           this.set = set;
       }
   }
   
   public static boolean isSingleCompBipartite(ArrayList<Edge>[]graph,int src,int[]vis) {
       ArrayDeque<Pair>q = new ArrayDeque<>();
       
       q.add(new Pair(src,1));
       
       while(q.size() > 0) {
           //remove
           Pair rem = q.remove();
           
           //mark*
           if(vis[rem.vtx] != 0) {
               //old set number is stored is vis, new set number 
               if(vis[rem.vtx] != rem.set) {
                   return false;
               }
               continue;
           }
           vis[rem.vtx] = rem.set;
           
           //add unvisited nbrs
           for(Edge edge : graph[rem.vtx]) {
               int nbr = edge.nbr;
               
               if(vis[nbr] == 0) {
                   int nbrset = (rem.set == 2) ? 1 : 2;
                   q.add(new Pair(nbr,nbrset));
               }
           }
       }
       
       return true;
   }
   
   public static boolean bipartite(ArrayList<Edge>[]graph) {
       int[]vis = new int[graph.length];
       
       for(int src = 0; src < graph.length;src++) {
           if(vis[src] == 0) {
               boolean sca = isSingleCompBipartite(graph,src,vis);
               
               if(sca == false) {
                   return false;
               }
           }
       }
       
       return true;
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // write your code here
      System.out.println(bipartite(graph));
   }
}