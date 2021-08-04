//leetcode https://leetcode.com/problems/critical-connections-in-a-network/


class Solution {
     static int[]par;
     static int[]disc;
     static int[]low;
     static boolean[]ap;
     static int time;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>>ans = new ArrayList<>();
        
        //create graph
        ArrayList<Integer>[]graph = new ArrayList[n];
        
        for(int i=0; i < n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i < connections.size();i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        boolean[]vis = new boolean[n];
        par = new int[n];
        disc = new int[n];
        low = new int[n];
        ap = new boolean[n];
        time = 0;
        
        par[0] = -1;
        critical_connection(0,graph,ans,vis);
        
        return ans;
    }
    
    public static void critical_connection(int src,ArrayList<Integer>[]graph,List<List<Integer>>ans, boolean[]vis) {
        
        vis[src] = true;
        disc[src] = low[src] = time;
        time++;
        
        for(int nbr : graph[src]) {
            if(par[src] == nbr) {
                //do nothing
            }
            else if(vis[nbr] == true) {
                low[src] = Math.min(low[src],disc[nbr]);
            }
            else if(vis[nbr] == false) {
                par[nbr] = src;
                critical_connection(nbr,graph,ans,vis);
                low[src] = Math.min(low[src],low[nbr]);
                
                //bridge
                if(disc[src] < low[nbr]) {
                    ArrayList<Integer>cc = new ArrayList<>();
                    cc.add(src);
                    cc.add(nbr);
                    
                    ans.add(cc);
                }
            }
        }
    }

    
}