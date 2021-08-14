import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int v = Integer.parseInt(st[0]);
    int e = Integer.parseInt(st[1]);

    int[] wells = new int[v];
    String[] words = br.readLine().split(" ");

    for (int i = 0; i < wells.length; i++) {
      wells[i] = Integer.parseInt(words[i]);
    }

    int[][] pipes = new int[e][3];
    for (int i = 0; i < e; i++) {
      String[] st1 = br.readLine().split(" ");
      pipes[i][0] = Integer.parseInt(st1[0]);
      pipes[i][1] = Integer.parseInt(st1[1]);
      pipes[i][2] = Integer.parseInt(st1[2]);

    }

    System.out.println(minCostToSupplyWater(v, wells, pipes));

  }

  public static class Edge {
      int src;
      int nbr;
      int wt;
      
      Edge(int src,int nbr,int wt) {
          this.src = src;
          this.nbr = nbr;
          this.wt = wt;
      }
  }
  
  public static class Pair implements Comparable<Pair>{
      int v;
      int wt;
      
      Pair() {
          
      }
      Pair(int v,int wt) {
          this.v = v;
          this.wt = wt;
      }
      
      public int compareTo(Pair o) {
          return this.wt - o.wt;
      }
  }

  public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
    ArrayList<ArrayList<Edge>>graph = new ArrayList<>();
    
    for(int i=0; i < n;i++) {
        graph.add(new ArrayList<>());
    }
    
    for(int i=0; i < pipes.length;i++) {
        int u = pipes[i][0]-1;
        int v = pipes[i][1]-1;
        int wt = pipes[i][2];
        
        graph.get(u).add(new Edge(u,v,wt));
        graph.get(v).add(new Edge(v,u,wt));
    }
    
    
    //add main supply vertex to the graph, connect it to all the other vertices
    graph.add(new ArrayList<>());
    
    for(int i=0; i < n;i++) {
        graph.get(n).add(new Edge(n,i,wells[i]));
        graph.get(i).add(new Edge(i,n,wells[i]));
    }
    
    //perform prim's min cost
    PriorityQueue<Pair>pq = new PriorityQueue<>();
    
    boolean[]vis = new boolean[graph.size()];
    
    pq.add(new Pair(0,0));
    int cost = 0;
    
    while(pq.size() > 0) {
        //remove
        Pair rem = pq.remove();
        
        //mark*
        if(vis[rem.v] == true) {
            continue;
        }
        vis[rem.v] = true;
        
        //work
        cost += rem.wt;
        
        //add unvisited nbrs
        for(Edge ne : graph.get(rem.v)) {
            int nbr = ne.nbr;
            
            if(vis[nbr] == false) {
                pq.add(new Pair(nbr,ne.wt));
            }
        }
    }
    
    return cost;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
