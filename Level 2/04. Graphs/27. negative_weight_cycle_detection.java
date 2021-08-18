https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        
        int[]cost = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        
        cost[0] = 0; //assume 0 src
        
        
        //perform bellmanford
        for(int itr = 1; itr <= n-1;itr++) {
            for(int i=0; i < edges.length;i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                int wt = edges[i][2];
                
                
                if(cost[u] == Integer.MAX_VALUE) {
                    continue;
                }
                else if(cost[u] + wt < cost[v]) {
                    cost[v] = cost[u] + wt;
                }
            }
        }
        
        
        //perform vth iteration
        for(int i=0; i < edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            
            if(cost[u] == Integer.MAX_VALUE) {
                continue;
            }
            else if(cost[u] + wt < cost[v]) {
                //negative wt cycle
                return 1;
            }
        }
        
        return 0;
        
    }
}