import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[][] matrix) {
		//write your code here

	    int n = matrix.length;
        int m = matrix[0].length;
        
        int[][]dp = new int[n][m];
        int omax = 0;
        
        for(int i = n-1; i >= 0;i--) {
            for(int j = m-1; j >= 0;j--) {
                if(i == n-1 || j == m-1 || matrix[i][j] == 0) {
                    dp[i][j] = matrix[i][j];
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i+1][j+1]) + 1;
                }
                
                omax = Math.max(omax,dp[i][j]);
            }
        }
        
        return omax;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m =scn.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0 ; i < n; i++){
			for(int j = 0 ; j < m; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		System.out.println(solution(arr));
	}

}