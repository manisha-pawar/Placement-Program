import java.util.*;

public class Main {

	public static int solution(String str) {
		// write your code here
		
		int i = -1;
		int j = -1;
		HashMap<Character,Integer>map = new HashMap<>();
		int count = 0;
		
		while(i < str.length()-1) {
		    //aquire
		    while(i < str.length()-1) {
		        i++;
		        char ch = str.charAt(i);
		        int nf = map.getOrDefault(ch,0) + 1;
		        map.put(ch,nf);
		        
		        if(nf >= 2) {
		            break;
		        }
		        else {
		            //count
		            count += i-j;
		        }
		    }
		    
		    //release to be valid again
		    while(j < i) {
		        j++;
		        char ch = str.charAt(j);
		        
		        if(map.get(ch) == 1) {
		            map.remove(ch);
		        }
		        else {
		            int nf = map.get(ch) - 1;
		            map.put(ch,nf);
		            count += i - j;
		            break;
		        }
		    }
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
