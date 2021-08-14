//https://practice.geeksforgeeks.org/problems/euler-circuit-and-path/1

class Solution
{
    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        
        int[]degree = new int[V];
        
        for(int i=0; i < V;i++) {
            int nbrc = adj.get(i).size();
            degree[i] = nbrc;
        }
        
        
        int odc = 0;
        int edc = 0;
        
        for(int i=0; i < V;i++) {
            if(degree[i] % 2 == 0) {
                edc++;
            }
            else {
                odc++;
            }
        }
        
        //eulerian cicuit -> each vertex shoudl have even degree
        if(edc == V) {
            return 2;
        }
        
        //eulerian path -> only two vertices have odd degree, make one vertex as src and the other as dest
        if(odc == 2) {
            return 1;
        }
        
        return 0;
    }
}