//lintcode https://www.lintcode.com/problem/434

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */

    static int[]parent;
    static int[]rank;

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer>ans = new ArrayList<>();

        if(operators == null || operators.length == 0) {
            return ans;
        }

        parent = new int[n*m];
        rank = new int[n*m];

        for(int i=0; i < parent.length;i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        
        int count = 0;

        int[][]dir = {{-1,0},{0,-1},{1,0},{0,1}};
        int[][]grid = new int[n][m];

        for(Point p : operators) {
            int px = p.x;
            int py = p.y;

            if(grid[px][py] == 1) {
                ans.add(count);
                continue;
            }
            
            grid[px][py] = 1;
            
            count++;

            //merge if required with nbr
            for(int[]d : dir) {
                int nx = px + d[0];
                int ny = py + d[1];

                if(nx >= 0 && nx < n && ny >=0 && ny < m && grid[nx][ny] == 1) {
                    int bnp = px*m + py; //box number parent
                    int bnn = nx*m + ny; //box number number

                    //union
                    int lp = find(bnp);
                    int ln = find(bnn);

                    if(lp != ln) {
                        //merging is required
                        if(rank[lp] < rank[ln]) {
                            parent[lp] = ln;
                        }
                        else if(rank[lp] > rank[ln]) {
                            parent[ln] = lp;
                        }
                        else {
                            parent[lp] = ln;
                            rank[ln]++;
                        }
                        count--;
                    }
                }
            }

            ans.add(count);
        }

        return ans;

        
    }


    public int find(int x) {

        if(parent[x] == x) {
            return x;
        }
        else {
            int temp = find(parent[x]);
            parent[x] = temp; //path compression
            return temp;
        }
    }
}