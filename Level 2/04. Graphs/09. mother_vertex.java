//GFG : Mother vertex https://practice.geeksforgeeks.org/problems/mother-vertex/1


class Solution {
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList < ArrayList < Integer >> adj) {
        // Code here

        //1. to fill the stack
        int v = adj.size();
        Stack < Integer > st = new Stack < > ();
        boolean[] vis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (vis[i] == false) {
                dfs(adj, i, vis, st);
            }
        }


        //2. is pmv is actually a mother vertex or not
        int pmv = st.peek();
        vis = new boolean[v];
        dfs(adj, pmv, vis);

        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == false) {
                return -1;
            }
        }

        return pmv;
    }


    public void dfs(ArrayList < ArrayList < Integer >> graph, int src, boolean[] vis, Stack < Integer > st) {

        vis[src] = true;

        for (int nbr: graph.get(src)) {
            if (vis[nbr] == false) {
                dfs(graph, nbr, vis, st);
            }
        }

        st.push(src);

    }


    public void dfs(ArrayList < ArrayList < Integer >> graph, int src, boolean[] vis) {

        vis[src] = true;

        for (int nbr: graph.get(src)) {
            if (vis[nbr] == false) {
                dfs(graph, nbr, vis);
            }
        }

    }


}