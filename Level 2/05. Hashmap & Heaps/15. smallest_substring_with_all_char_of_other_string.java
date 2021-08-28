//https://leetcode.com/problems/minimum-window-substring/


class Solution {
    public String minWindow(String s1, String s2) {
        
        HashMap<Character,Integer>map1 = new HashMap<>();
		HashMap<Character,Integer>map2 = new HashMap<>();
		
		//freq map of s2
		for(int i=0; i < s2.length();i++) {
		    char ch = s2.charAt(i);
		    
		    if(map2.containsKey(ch) == false) {
		        map2.put(ch,1);
		    }
		    else {
		        int nf = map2.get(ch) + 1;
		        map2.put(ch,nf);
		    }
		}
		
		int oans = Integer.MAX_VALUE;
        int oi = -1;
        int oj = -1;
        
		int i=-1,j=-1;
		
		int mtc = 0; //match count
		int dmtc = s2.length(); //desired match count
		
		
		while(i < s1.length()-1) {
		    
		    //1. aquire
		    while(i < s1.length()-1 && mtc < dmtc) {
		        i++;
		        
		        //aquire this ith char
		        char ch = s1.charAt(i);
		        
		        if(map1.containsKey(ch) == false) {
		            map1.put(ch,1);
    		    }
    		    else {
    		        int nf = map1.get(ch) + 1;
    		        map1.put(ch,nf);
    		    }
    		 
    		    
    		    //impact on match count
    		    if(map1.getOrDefault(ch,0) <= map2.getOrDefault(ch,0)) {
    		        mtc++;
    		    }
		    }
		    
		    
		    //2. release
		    while(j < i && mtc == dmtc) {
		        int len = i - j;
		        
		        if(len < oans) {
		            oans = len;
                    oi = i;
                    oj = j;
		        }
		        
		        j++;
		        //release jth char
		        char ch = s1.charAt(j);
		        
		        if(map1.get(ch) == 1) {
		            map1.remove(ch);
		        }
		        else {
		            int nf = map1.get(ch) - 1;
		            map1.put(ch,nf);
		        }
		        
		        
		        //impact on match count
		        if(map1.getOrDefault(ch,0) < map2.getOrDefault(ch,0)) {
		            mtc--;
		        }
		    }
		}
		
        String ans = s1.substring(oj+1,oi+1);
		return ans;
    }
}