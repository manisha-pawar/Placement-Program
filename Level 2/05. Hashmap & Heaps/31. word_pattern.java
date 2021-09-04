//https://leetcode.com/problems/word-pattern/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[]words = s.split(" ");
        
        if(pattern.length() != words.length) {
            return false;    
        }
        
        HashMap<Character,String>map = new HashMap<>();
        HashSet<String>hs = new HashSet<>();
        
        for(int i=0; i < pattern.length();i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            
            if(map.containsKey(ch) == false) {
                if(hs.contains(word) == true) {
                    return false;
                }
                map.put(ch,word);
                hs.add(word);
            }
            else {
                if(map.get(ch).equals(word) == false) {
                    return false;
                }
            }
        }
        
        return true;
    }
}