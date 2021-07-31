//leetcode 934 shortest bridge

class Solution {
    static class Pair {
        int i;
        int j;

        Pair() {

        }

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int shortestBridge(int[][] grid) {

        ArrayDeque < Pair > q = new ArrayDeque < > ();
        boolean flag = false;

        for (int i = 0; i < grid.length && flag == false; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, q);
                    flag = true;
                    break;
                }
            }
        }

        int lev = 0;

        while (q.size() > 0) {
            int count = q.size();

            while (count-- > 0) {
                //remove
                Pair rem = q.remove();
                int ri = rem.i;
                int rj = rem.j;

                //add nbr
                for (int i = 0; i < 4; i++) {
                    int ni = ri + dir[i][0];
                    int nj = rj + dir[i][1];

                    if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] != -1) {
                        if (grid[ni][nj] == 1) {
                            return lev;
                        }

                        grid[ni][nj] = -1;
                        q.add(new Pair(ni, nj));
                    }
                }

            }

            lev++;
        }

        return -1;


    }

    int[][] dir = {
        {
            -1, 0
        },
        {
            0,
            -1
        },
        {
            1,
            0
        },
        {
            0,
            1
        }
    };

    public void dfs(int[][] grid, int r, int c, ArrayDeque < Pair > q) {

        grid[r][c] = -1;
        q.add(new Pair(r, c));

        for (int i = 0; i < 4; i++) {
            int ni = r + dir[i][0];
            int nj = c + dir[i][1];

            if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == 1) {
                dfs(grid, ni, nj, q);
            }
        }


    }

}