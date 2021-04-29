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
        int v;
        String psf;

        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }

        Pair() {

        }
    }

    public static void bfs(ArrayList < Edge > [] graph, int src) {
        boolean[] vis = new boolean[graph.length];
        Queue < Pair > q = new ArrayDeque < > ();

        q.add(new Pair(src, src + ""));

        while (q.size() > 0) {

            Pair rem = q.remove();

            if (vis[rem.v] == true) {
                continue;
            }

            vis[rem.v] = true;

            System.out.println(rem.v + "@" + rem.psf);

            for (Edge edge: graph[rem.v]) {
                int nbr = edge.nbr;

                if (vis[nbr] == false) {
                    q.add(new Pair(nbr, rem.psf + nbr));
                }
            }

        }

    }


    public static class LPair {
        int v;
        int lev;

        LPair(int v, int lev) {
            this.v = v;
            this.lev = lev;
        }

        LPair() {

        }
    }

    public static void bfs_level_wise(ArrayList < Edge > [] graph, int src) {
        boolean[] vis = new boolean[graph.length];
        Queue < LPair > q = new ArrayDeque < > ();

        q.add(new LPair(src, 0));

        while (q.size() > 0) {
            int s = q.size();

            for (int i = 0; i < s; i++) {
                LPair rem = q.remove();

                if (vis[rem.v] == true) {
                    continue;
                }

                vis[rem.v] = true;

                System.out.print(rem.v + " ");

                for (Edge edge: graph[rem.v]) {
                    int nbr = edge.nbr;

                    if (vis[nbr] == false) {
                        q.add(new LPair(nbr, rem.lev + 1));
                    }
                }
            }

            System.out.println();
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }


        int src = Integer.parseInt(br.readLine());

        bfs(graph, src);

        // write your code here  
    }
}