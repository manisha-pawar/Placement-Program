//GFG : Kosaraju for strongly connected components https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1


class Solution {
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList < ArrayList < Integer >> graph) {
        //1. fill stack, using dfs
        int v = graph.size();
        boolean[] vis = new boolean[v];
        Stack < Integer > st = new Stack < > ();

        for (int i = 0; i < v; i++) {
            if (vis[i] == false) {
                dfs(graph, i, vis, st);
            }
        }

        //2. reverse all edges
        ArrayList < ArrayList < Integer >> rev_graph = new ArrayList < > ();
        for (int i = 0; i < v; i++) {
            rev_graph.add(new ArrayList < > ());
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                int src = i;
                int nbr = graph.get(i).get(j);

                rev_graph.get(nbr).add(src);
            }
        }


        //3. to count scc (dfs), using the order present in stack
        int scc = 0;
        vis = new boolean[v];

        while (st.size() > 0) {
            int top = st.pop();

            if (vis[top] == false) {
                dfs(rev_graph, top, vis);
                scc++;
            }
        }

        return scc;


    }


    public static void dfs(ArrayList < ArrayList < Integer >> graph, int src, boolean[] vis, Stack < Integer > st) {

        vis[src] = true;

        for (int nbr: graph.get(src)) {
            if (vis[nbr] == false) {
                dfs(graph, nbr, vis, st);
            }
        }

        st.push(src);
    }

    public static void dfs(ArrayList < ArrayList < Integer >> graph, int src, boolean[] vis) {

        vis[src] = true;

        for (int nbr: graph.get(src)) {
            if (vis[nbr] == false) {
                dfs(graph, nbr, vis);
            }
        }

    }
}