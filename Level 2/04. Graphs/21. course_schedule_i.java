class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //create graph
        ArrayList<Integer>[]graph = new ArrayList[numCourses];
        int[]indeg = new int[graph.length];
        
        for(int i=0; i < graph.length;i++) {
            graph[i] = new ArrayList<>();
        }
        
       
        for(int i=0; i < prerequisites.length;i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            
            graph[a].add(b);
            indeg[b]++;
        }
        
        
        ArrayList<Integer>order = kahn(graph,indeg);
        
        //reverse
        Collections.reverse(order);
        
        if(order.size() != numCourses) {
            return false;
        }
        else {
            return true;
        }
        
    }
    
    
    
    public ArrayList<Integer> kahn(ArrayList<Integer>[]graph,int[]indeg) {
        ArrayDeque<Integer>q = new ArrayDeque<>();
        
        //1. add vertices with '0' indegree in the queue
        for(int i=0; i < indeg.length;i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }
        
        ArrayList<Integer>order = new ArrayList<>();
        
        while(q.size() > 0) {
            int rem = q.remove();
            order.add(rem);
            
            for(int nbr : graph[rem]) {
                indeg[nbr]--;
                if(indeg[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }
        
        
        //return topological sort
        return order;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}