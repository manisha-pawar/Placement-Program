import java.util.*;

public class Main {

	public static int solution(String str){
		// write your code here
		
		HashSet<Character>hs = new HashSet<>();
		HashMap<Character,Integer>map = new HashMap<>();
		
		for(int i=0; i < str.length();i++) {
		    char ch = str.charAt(i);
		    hs.add(ch);
		}
		
		int i = -1;
		int j = -1;
		
		int oans = Integer.MAX_VALUE;
		
		while(i < str.length()-1) {
		    //aquire
		    while(i < str.length() - 1 && map.size() < hs.size()) {
		        i++;
		        
		        char ch = str.charAt(i);
		        
		        int nf = map.getOrDefault(ch,0) + 1;
		        map.put(ch,nf);
		    }
		    
		    //release
		    while(j < i && map.size() == hs.size()) {
		        int len = i - j;
		        
		        if(len < oans) {
		            oans = len;
		        }
		        
		        
		        j++;
		        char ch = str.charAt(j);
		        
		        if(map.get(ch) == 1) {
		            map.remove(ch);
		        }
		        else {
		            int nf = map.get(ch) - 1;
		            map.put(ch,nf);
		        }
		    }
		}
		
		return oans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
