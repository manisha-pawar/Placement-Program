class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int vertices = edges.length;
        int[]indeg = new int[vertices + 1]; //1 based
        
        Arrays.fill(indeg,-1);
        
        int e1 = -1;
        int e2 = -1;
        
        for(int i=0; i < edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            if(indeg[v] == -1) {
                //nothing to do  
            }
            else {
                e1 = indeg[v];
                e2 = i;
            }
            
            indeg[v] = i;
        }
        
    
        
        int ei = dsu(edges,e2); //restrict e2 and then do dsu
        
        
        if(e1 == -1 && e2 == -1) {
            //case 2
            return edges[ei];
        }
        
        //case 1,case 3
        if(ei == -1) {
            return edges[e2];
        }
        else {
            return edges[e1];
        }
    }
    
    static int[]parent;
    static int[]rank;
    
    public int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
    
    
    public int dsu(int[][]edges,int e2) {
        
        int vtc = edges.length;
        parent = new int[vtc+1];
        rank = new int[vtc+1];
        
        for(int i=1; i <= vtc;i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int i=0; i < edges.length;i++) {
            if(i == e2) {
                continue;
            }
            
            int u = edges[i][0];
            int v = edges[i][1];
            
            int lu = find(u);
            int lv = find(v);
            
            if(lu != lv) {
                //merge
                if(rank[lu] < rank[lv]) {
                    parent[lu] = lv;
                }
                else if(rank[lu] > rank[lv]) {
                    parent[lv] = lu;
                }
                else {
                    parent[lu] = lv;
                    rank[lv]++;
                }
            }
            else {
                return i;
            }
        }
        
        return -1;
    }
    
    
}