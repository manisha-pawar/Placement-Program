import java.util.*;

public class Main {
	
	public static boolean solution(String s1, String s2){
		// write your code here
		
		if(s1.length() != s2.length()) {
		    return false;
		}
		
        HashMap<Character,Integer>map = new HashMap<>();
        
        for(int i=0; i < s1.length();i++) {
            char ch = s1.charAt(i);
            int nf = map.getOrDefault(ch,0) + 1;
            map.put(ch,nf);
        }
        
        for(int i=0; i < s2.length();i++) {
            char ch = s2.charAt(i);
            int nf = map.getOrDefault(ch,0) - 1;
            map.put(ch,nf);
        }
        
        for(char key : map.keySet()) {
            if(map.get(key) != 0) {
                return false;
            }
        }
        
 		return true;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
