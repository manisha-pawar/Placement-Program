import java.util.*;

public class Main {

	public static int solution(String str, int k) {
		// write your code here
		
		HashMap<Character,Integer>map = new HashMap<>();
		int i = -1;
		int j = -1;
		int ans = 0;
		
		
		while(i <  str.length()-1) {
		    
		    while(i < str.length()-1) {
		        i++;
		        char ch = str.charAt(i);
		        int nf = map.getOrDefault(ch,0) + 1;
		        map.put(ch,nf);
		        
		        if(map.size() <= k) {
		            //create ans
		            int len = i - j;
		            ans = Math.max(ans,len);
		        }
		        else {
		            //invalid
		            break;
		        }
		    }
		    
		    
		    while(j < i && map.size() > k)  {
		        j++;
		        char ch = str.charAt(j);
		        
		        if(map.get(ch) == 1) {
		            map.remove(ch);
		        }
		        else {
		            int nf = map.get(ch)-1;
		            map.put(ch,nf);
		        }
		    }
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
