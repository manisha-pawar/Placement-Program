class Solution {
    public int find(int[]parent,int x) {
        if(parent[x] == x) {
            return x;
        }
        
        int temp = find(parent,parent[x]);
        parent[x] = temp; //path compression
        return temp;
    }
    
    public boolean union(int[]parent,int[]rank,int x,int y) {
        int lx = find(parent,x);
        int ly = find(parent,y);
        
        if(lx != ly) {
            //merging is required
            if(rank[lx] < rank[ly]) {
                parent[lx] = ly;
            }
            else if(rank[lx] > rank[ly]) {
                parent[ly] = lx;
            }
            else {
                parent[lx] = ly;
                rank[ly]++;
            }
            return true;
        }
        else {
            //merging is not required
            return false;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[]parentA = new int[n+1];
        int[]rankA = new int[n+1];
        
        int[]parentB = new int[n+1];
        int[]rankB = new int[n+1];
        
        for(int i=1; i <= n ;i++) {
            parentA[i] = parentB[i] = i;
            rankA[i] = rankB[i] = 0;
        }
        
        //sort this array, because we have to prioratise type-3
        Arrays.sort(edges,(a,b)->{
            //-ve -> a < b
            //+ve -> a > b
            //0 -> a == b
            
            if(a[0] == 3) {
                return -1;
            }
            else if(b[0] == 3) {
                return 1;
            }
            else {
                return 0;
            }
        });
        
        int remc = 0;
        int ca = 1;
        int cb = 1;
        
        for(int i=0; i < edges.length;i++) {
            int type = edges[i][0];
            int u = edges[i][1];
            int v = edges[i][2];
            
            if(type == 3) {
                //alice, bob
                boolean ma = union(parentA,rankA,u,v);
                boolean mb = union(parentB,rankB,u,v);
                
                if(ma == true && mb == true) {
                    ca++;
                    cb++;
                }
                else if(ma == false && mb == false) {
                    remc++;
                }
                
            }
            else if(type == 1) {
                //alice
                 boolean ma = union(parentA,rankA,u,v);
                
                if(ma == true) {
                    ca++;
                }
                else {
                    remc++;
                }
            }
            else {
                //bob
                 boolean mb = union(parentB,rankB,u,v);
                
                if(mb == true) {
                    cb++;
                }
                else {
                    remc++;
                }
                
            }
        }
        
        
        if(ca == n && cb == n) {
            return remc;
        }
        
        return -1;
        
    }
    
}