import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String str) {
	    int len = str.length();
	    
		int[]next = new int[len];
		int[]prev = new int[len];
		HashMap<Character,Integer>map = new HashMap<>();
		
		//travel from right to left
		for(int i=len-1; i >= 0;i--) {
		    char ch = str.charAt(i);
		    next[i] = map.getOrDefault(ch,-1);
		    map.put(ch,i);
		}
		
		map.clear();
		
		
		//travel from left to right
		for(int i=0; i < len;i++) {
		    char ch = str.charAt(i);
		    prev[i] = map.getOrDefault(ch,-1);
		    map.put(ch,i);
		}
		
		
		int[][]dp = new int[len][len];
		
		for(int d = 0; d < len;d++) {
		    for(int i = 0, j = d; j < len;i++,j++) {
    		    if(d == 0) {
    		       dp[i][j] = 1; 
    		    }
    		    else if(d == 1) {
    		        dp[i][j] = 2;
    		    }
    		    else {
    		        if(str.charAt(i) != str.charAt(j)) {
    		            dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
    		        }
    		        else {
    		            if(next[i] > prev[j]) {
    		                //case 1
    		                dp[i][j] = 2*dp[i+1][j-1] + 2;
    		            }
    		            else if(next[i] == prev[j]) {
    		                //case 2
    		                dp[i][j] = 2*dp[i+1][j-1] + 1;
    		            }
    		            else {
    		                //case 3
    		                int n = next[i];
    		                int p = prev[j];
    		                
    		                dp[i][j] = 2*dp[i+1][j-1] - dp[n+1][p-1];
    		            }
    		        }
    		    }
		    }
		  
		}
		
		 return dp[0][len-1];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}