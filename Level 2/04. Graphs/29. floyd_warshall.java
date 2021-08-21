//https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1

class Solution
{
    public void shortest_distance(int[][] matrix)
    {     
        //to select an indermediate
        for(int k=0; k < matrix.length;k++) {
            //to select a src
            for(int u=0; u < matrix.length;u++) {
                //to select a dest
                for(int v=0; v < matrix.length;v++) {
                    if(u == v || u == k || v == k || matrix[u][k] == -1 || matrix[k][v] == -1) {
                        continue;
                    }
                    else if(matrix[u][v] == -1 || matrix[u][k] + matrix[k][v] < matrix[u][v]) {
                        matrix[u][v] = matrix[u][k] + matrix[k][v];
                    }
                }
            }
        }
    }
}