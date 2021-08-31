//https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
 	    
 	    int i = -1, j  = -1;
 	    int oans = 0;
 	    
 	    while(i < s.length()-1) {
 	        //aquire
 	        while(i < s.length() - 1) {
 	            i++;
 	            char ch = s.charAt(i);
 	            
 	            int nf = map.getOrDefault(ch,0) + 1;
 	            map.put(ch,nf);
 	            
 	            if(nf >= 2) {
 	                //invalid
 	                break;
 	            }
 	            else {
 	                //ans updation step
     	            int len = i - j;
     	            
     	            if(len > oans) {
     	                oans = len;
     	            }
 	            }
 	        }
 	        
 	        
 	        //release -> to be valid again
 	        while(j < i) {
 	            
 	            j++;
 	            char ch = s.charAt(j);
 	            
 	            if(map.get(ch) == 1) {
 	                map.remove(ch);
 	            }
 	            else {
 	                int nf = map.get(ch) - 1; //we are valid again, let's go and aquire again
 	                map.put(ch,nf);
 	                break;
 	            }
 	        }
 	    }
 	    
 	    return oans;
    }
}