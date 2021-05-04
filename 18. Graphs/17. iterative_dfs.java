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
       String psf;
       
       Pair() {
           
       }
       
       Pair(int vtx,String psf) {
           this.vtx = vtx;
           this.psf = psf;
       }
   }
   
   public static void iterative_dfs(ArrayList<Edge>[]graph,int src) {
       boolean[]vis = new boolean[graph.length];
       
       Stack<Pair>st = new Stack<>();
       
       st.push(new Pair(src,src+""));
       
       while(st.size() > 0) {
           //remove
           Pair rem = st.pop();
           
           //mark*
           if(vis[rem.vtx] == true) {
               continue;
           } 
           vis[rem.vtx] = true;
           
           //work
           System.out.println(rem.vtx + "@" + rem.psf);
           
           //add unvisited nbr
           for(Edge edge : graph[rem.vtx]) {
               int nbr = edge.nbr;
               
               if(vis[nbr] == false) {
                   st.push(new Pair(nbr,rem.psf + nbr));
               }
           }
       }
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

      // write your code here 
      iterative_dfs(graph,src);
      
   }
}