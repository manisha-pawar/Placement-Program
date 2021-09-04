//https://practice.geeksforgeeks.org/problems/check-if-two-strings-are-k-anagrams-or-not/1

class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        // code here
        
        if(s1.length() != s2.length()) {
            return false;
        }
        
        HashMap<Character,Integer>map = new HashMap<>();
        
        for(int i=0; i < s1.length();i++) {
            char ch = s1.charAt(i);
            
            int nf = map.getOrDefault(ch,0) + 1;
            map.put(ch,nf);
        }
        
        //compensate using second string
        for(int i=0; i < s2.length();i++) {
            char ch = s2.charAt(i);
            
            int nf = map.getOrDefault(ch,0) - 1;
            map.put(ch,nf);
        }
        
        //count +ve values in map
        int count = 0;
        for(char key : map.keySet()) {
            if(map.get(key) > 0) {
                count += map.get(key);
            }
        }
        
        return count <= k;
    }
}