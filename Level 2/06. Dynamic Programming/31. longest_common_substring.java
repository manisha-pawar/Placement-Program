import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String s1, String s2){
		//write your code here
        
        s1 = "." + s1;
        s2 = "." + s2;
        int omax = 0;
        
        int[][]dp = new int[s1.length()][s2.length()];
        
        for(int i=1; i < dp.length;i++) {
            for(int j=1; j < dp[0].length;j++) {
                if(s1.charAt(i) != s2.charAt(j)) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                
                omax = Math.max(omax,dp[i][j]);
            }
        }
        
		return omax;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}