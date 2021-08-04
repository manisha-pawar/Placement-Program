import java.util.*;

public class DSU {
    static int[] parent;
    static int[] rank;

    public static void main(String[]args) {

        int[][]relations = {{1,3},{3,2},{5,9},{6,3},{10,5},{7,5},
        {8,2},{5,2}};

        parent = new int[11];
        rank = new int[11];

         //0 is blocked
         for(int i=1; i <= 10;i++) {
             parent[i] = i;
             rank[i] = 0;
         }

         for(int i=0; i < relations.length;i++) {
             int x = relations[i][0];
             int y = relations[i][1];

             union(x,y);
         }


         int groups = 0;

        //count total number of set leaders
         for(int i=1; i < parent.length;i++) {
             if(parent[i] == i) {
                 //i is a set leader
                 groups++;
             }
         }

        System.out.println(groups);

        // HashMap<Integer,ArrayList<Integer>>map = new HashMap<>();

        // //to fill parent array with set leaders for all elements
        // for(int i=1; i < parent.length;i++) {
        //     find(i); //for final path compression
        // }

        
        // for(int i=1; i < parent.length;i++) {
        //     int ele = i;
        //     int grp = parent[i];

        //     if(map.containsKey(grp) == true) {
        //         ArrayList<Integer>list = map.get(grp);
        //         list.add(ele);
        //         map.put(grp,list);
        //     }
        //     else {
        //         ArrayList<Integer>list = new ArrayList<>();
        //         list.add(ele);
        //         map.put(grp,list);
        //     }
        // }


        // System.out.println(map);

         
    }

    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }

        int temp = find(parent[x]);
        parent[x] = temp; //path compression
        return temp;
    }

    public static void union(int x,int y) {
        int lx = find(x);
        int ly = find(y);

        if(lx != ly) {
            //merging
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
            
        }
    }

}