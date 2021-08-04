import java.util.*;
import java.io.*;

class Main {

    static int[] par;
    static int[] disc;
    static int[] low;
    static boolean[] ap;
    static int dfsc = 0;
    static int time;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vertices = scn.nextInt();
        int edges = scn.nextInt();

        ArrayList < Integer > [] graph = new ArrayList[vertices];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList < > ();
        }

        while (edges-- > 0) {
            int u = scn.nextInt() - 1;
            int v = scn.nextInt() - 1;

            graph[u].add(v);
            graph[v].add(u);
        }

        int n = graph.length;
        boolean[] vis = new boolean[graph.length];
        par = new int[n];
        disc = new int[n];
        low = new int[n];
        ap = new boolean[n];
        dfsc = 0;
        time = 0;

        par[0] = -1;
        articulation_point(0, graph, vis);

        int count = 0;

        for (int i = 0; i < ap.length; i++) {
            if (ap[i] == true) {
                count++;
                // System.out.println(i);
            }
        }

        System.out.println(count);

    }


    public static void articulation_point(int src, ArrayList < Integer > [] graph, boolean[] vis) {
        vis[src] = true;

        disc[src] = low[src] = time;
        time++;

        for (int nbr: graph[src]) {
            if (par[src] == nbr) {
                //nothing to do
            } else if (vis[nbr] == true) {
                //visited nbr
                low[src] = Math.min(low[src], disc[nbr]);
            } else if (vis[nbr] == false) {


                //unvisited nbr
                par[nbr] = src;
                articulation_point(nbr, graph, vis);
                low[src] = Math.min(low[src], low[nbr]);

                //articulation point
                if (par[src] == -1) {
                    //original src
                    dfsc++;

                    if (dfsc >= 2) {
                        ap[src] = true;
                    }
                } 
                else if (disc[src] <= low[nbr]) {
                    ap[src] = true;
                }

                //bridge
                if (disc[src] < low[nbr]) {
                    System.out.println(src + "---" + nbr);
                }
            }
        }

    }

}