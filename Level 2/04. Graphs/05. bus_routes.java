class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        //bus stand number vs bus
        HashMap<Integer,ArrayList<Integer>>map = new HashMap<>();
        
        for(int i=0; i < routes.length;i++) {
            int bus_no = i;
            for(int j = 0; j < routes[i].length;j++) {
                int bus_stop_no = routes[i][j];
                
                if(map.containsKey(bus_stop_no) == false) {
                    ArrayList<Integer>list = new ArrayList<>();
                    list.add(bus_no);
                    map.put(bus_stop_no,list);
                }
                else {
                    ArrayList<Integer>list = map.get(bus_stop_no);
                    list.add(bus_no);
                    map.put(bus_stop_no,list);
                }
            }
        }
        
        int ans = helper(map,routes,source,target);
        return ans;
    }
    
    
    public int helper(HashMap<Integer,ArrayList<Integer>>map,int[][]routes,int src,int tar) {
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        HashSet<Integer>bus_vis = new HashSet<>();
        HashSet<Integer>bus_stop_vis = new HashSet<>();
        
        q.add(src);
        int lev = 0;
        
        while(q.size() > 0) {
            int count = q.size();
            
            while(count-- > 0) {
                //remove
                int rem = q.remove();
                
                if(rem == tar) {
                    return lev;
                }
                
                //mark
                if(bus_stop_vis.contains(rem) == true) {
                    continue;
                }
                
                bus_stop_vis.add(rem);
                
                //add nbr
                for(int bus : map.get(rem)) {
                    if(bus_vis.contains(bus) == false) {
                        bus_vis.add(bus);
                        for(int bus_stop : routes[bus]) {
                            if(bus_stop_vis.contains(bus_stop) == false) {
                                q.add(bus_stop);
                            }
                        }
                    }
                }
            }
            
            lev++;
        }
        
        return -1;
    }

    
}