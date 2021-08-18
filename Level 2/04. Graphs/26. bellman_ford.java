import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.*;

public class Main {
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

	public static void main(String[] args) throws NumberFormatException, IOException {
        
        Scanner scn = new Scanner(System.in);
        
        int v = scn.nextInt();
        int e = scn.nextInt();
        
        ArrayList<Edge>[]graph = new ArrayList[v];
        
        for(int i=0; i < graph.length;i++) {
            graph[i] = new ArrayList<>();
        }
        
        while(e-- > 0) {
            int s = scn.nextInt() - 1;
            int n = scn.nextInt() - 1;
            int wt = scn.nextInt();
            
            //undirected
            graph[s].add(new Edge(s,n,wt));
            graph[n].add(new Edge(n,s,wt));
        }
        
        
        bellmanFord(graph,0);
        
	}
	
	public static void bellmanFord(ArrayList<Edge>[]graph,int src) {
	    
	    ArrayList<Edge>edges = new ArrayList<>();
	    
	    for(int i=0; i < graph.length;i++) {
	        for(int j=0; j < graph[i].size();j++) {
	            Edge ne = graph[i].get(j);
	            
	            if(i < ne.nbr) {
	                //to maintain non-duplicacy of edges (in case of undirected graph)
	                edges.add(ne);
	            }
	        }
	    }
	    
	    
	    int[]cost = new int[graph.length];
	    Arrays.fill(cost,Integer.MAX_VALUE);
	    
	    cost[src] = 0;
	    
	    //perform bellmanford
	    for(int itr = 1; itr <= graph.length-1;itr++) {
	        for(int i=0; i < edges.size();i++) {
	            Edge e = edges.get(i);
	            int u = e.src;
	            int v = e.nbr;
	            int wt = e.wt;
	            
	            if(cost[u] == Integer.MAX_VALUE) {
	                continue;
	            }
	            else if(cost[u] + wt < cost[v]) {
	                cost[v] = cost[u] + wt;
	            }
	        }
	    }
	    
	    for(int i=0; i < cost.length;i++) {
	        if(i == src) {
	            continue;
	        }
	        System.out.print(cost[i] + " ");
	    }
	    System.out.println();
	    
	}
	
}
