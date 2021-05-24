import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        boolean[][] vis = new boolean[n][m];
        floodfill(arr, 0, 0, vis, "");
    }


    public static void floodfill(int[][] maze, int sr, int sc, boolean[][] visited, String asf) {
        if (sr == maze.length - 1 && sc == maze[0].length - 1) {
            System.out.println(asf);
            return;
        }

        if (sr < 0 || sc < 0 || sr >= maze.length || sc >= maze[0].length || maze[sr][sc] == 1 || visited[sr][sc] == true) {
            return;
        }


        visited[sr][sc] = true;

        //top move
        floodfill(maze, sr - 1, sc, visited, asf + "t");
        //left move
        floodfill(maze, sr, sc - 1, visited, asf + "l");
        //down move
        floodfill(maze, sr + 1, sc, visited, asf + "d");
        //right move
        floodfill(maze, sr, sc + 1, visited, asf + "r");

        visited[sr][sc] = false;

    }
}
