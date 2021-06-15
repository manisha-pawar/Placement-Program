import java.io.*;
import java.util.*;

public class Main {
	static int max = 0;
	static int scg = 0; //single component gold

	public static void getMaxGold(int[][] arr) {

		int n = arr.length;
		int m = arr[0].length;

		boolean[][] vis = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != 0 && vis[i][j] == false) {
					scg = 0;
					dfs(arr, vis, i, j);
					System.out.println(scg);
					max = Math.max(scg, max);
				}
			}
		}

	}

	public static void dfs(int[][] arr, boolean[][] vis, int i, int j) {
		if (i < 0 || j < 0 || i == arr.length || j == arr[0].length || vis[i][j] == true || arr[i][j] == 0) {
			return;
		}

		vis[i][j] = true;
		scg += arr[i][j];

		//top
		dfs(arr, vis, i - 1, j);

		//left
		dfs(arr, vis, i, j - 1);

		//down
		dfs(arr, vis, i + 1, j);

		//right
		dfs(arr, vis, i, j + 1);

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
	}

}