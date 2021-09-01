//https://leetcode.com/problems/find-all-anagrams-in-a-string/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans = new ArrayList<>();
        
        if(p.length() > s.length()) {
            return ans;
        }
        
        int i = 0;
        int j = 0;
        
        HashMap<Character,Integer>pm = new HashMap<>(); //fmap for pattern
        HashMap<Character,Integer>wm = new HashMap<>(); //fmap for window
        
        for(i=0; i < p.length();i++) {
            char ch = p.charAt(i);
            int nf = pm.getOrDefault(ch,0) + 1;
            pm.put(ch,nf);
        }
        
        //first window
        for(i = 0; i < p.length();i++) {
            char ch = s.charAt(i);
            int nf = wm.getOrDefault(ch,0) + 1;
            wm.put(ch,nf);
        }
        
        
        
        for(; i < s.length();i++,j++) {
            if(mapsAreEqual(wm,pm) == true) {
                ans.add(j);
            }
            
            //aquire ith char
            char chi = s.charAt(i);
            int nf = wm.getOrDefault(chi,0) + 1;
            wm.put(chi,nf);
            
            //release jth char
            char chj = s.charAt(j);
            if(wm.get(chj) == 1) {
                wm.remove(chj);
            }
            else {
                int nfj = wm.get(chj) - 1;
                wm.put(chj,nfj);
            }
            
        }
        
        if(mapsAreEqual(wm,pm) == true) {
                ans.add(j);
        }
        
        return ans;
    }
    
    public static boolean mapsAreEqual(HashMap<Character,Integer>map1,HashMap<Character,Integer>map2) {
        if(map1.size() != map2.size()) {
            return false;
        }
        
        
        for(char ch : map1.keySet()) {
            int f1 = map1.get(ch);
            
            if(map2.containsKey(ch) == false) {
                return false;
            }
            
            int f2 = map2.get(ch);
            
            if(f1 != f2) {
                return false;
            }
        }
        
        return true;
    }
     
}