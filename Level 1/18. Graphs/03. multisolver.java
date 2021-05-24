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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
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

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        int criteria = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vtces];
        multisolver(graph, src, dest, visited, criteria, k, src + "", 0);

        System.out.println("Smallest Path = " + spath + "@" + spathwt);
        System.out.println("Largest Path = " + lpath + "@" + lpathwt);
        System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
        System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
        kthLargest(graph, k, src, dest);
    }


    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;
    
    public static void multisolver(ArrayList < Edge > [] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {

        if (src == dest) {
            //smallest path
            if (wsf < spathwt) {
                spathwt = wsf;
                spath = psf;
            }

            //largest path
            if (wsf > lpathwt) {
                lpathwt = wsf;
                lpath = psf;
            }

            //ceil path -> qualified min
            if (wsf > criteria && cpathwt > wsf) {
                cpathwt = wsf;
                cpath = psf;
            }

            //floor path -> qualified max
            if (wsf < criteria && fpathwt < wsf) {
                fpathwt = wsf;
                fpath = psf;
            }


            return;
        }

        visited[src] = true;

        for (Edge edge: graph[src]) {

            if (visited[edge.nbr] == false) {
                multisolver(graph, edge.nbr, dest, visited, criteria, k, psf + edge.nbr, wsf + edge.wt);
            }
        }

        visited[src] = false;

    }


    public static void kthLargest(ArrayList < Edge > [] graph, int k, int src, int dest) {

        int factor = Integer.MAX_VALUE;
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < k; i++) {
            fpath = "";
            fpathwt = Integer.MIN_VALUE;
            multisolver(graph, src, dest, vis, factor, k, src + "", 0);
            factor = fpathwt;
        }

        String kthLP = fpath;
        int kthLPwt = fpathwt;

        System.out.println(k + "th largest path = " + kthLP + "@" + kthLPwt);
    }

}