import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        // write your code here
        int ans = islands(arr);
        System.out.println(ans);
    }

    public static void dfs(int[][] arr, int i, int j, boolean[][] vis) {
        if (i < 0 || j < 0 || i == arr.length || j == arr[0].length || vis[i][j] == true || arr[i][j] == 1) {
            return;
        }

        vis[i][j] = true;

        //top nbr
        dfs(arr, i - 1, j, vis);

        //left nbr
        dfs(arr, i, j - 1, vis);

        //down nbr
        dfs(arr, i + 1, j, vis);

        //right nbr
        dfs(arr, i, j + 1, vis);
    }

    public static int islands(int[][] arr) {

        int count = 0;
        boolean[][] vis = new boolean[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0 && vis[i][j] == false) {
                    count++;
                    dfs(arr, i, j, vis);
                }
            }
        }

        return count;
    }

}