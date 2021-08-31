//https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1


class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        
        int i = -1;
        int j = -1;
        int ans = -1;
        HashMap<Character,Integer>map = new HashMap<>();
        
        while(i < s.length()-1) {
            
            //aquire to be valid
            while(i < s.length()-1) {
                i++;
                char ch = s.charAt(i);
                int nf = map.getOrDefault(ch,0) + 1;
                map.put(ch,nf);
                
                if(map.size() == k) {
                    int len = i - j;
                    ans = Math.max(ans,len);
                }
                else if(map.size() > k) {
                    break;
                }
            }
            
            //release to be valid
            while(j < i) {
                j++;
                char ch = s.charAt(j);
                
                if(map.get(ch) == 1) {
                    map.remove(ch);
                }
                else {
                    int nf = map.get(ch) - 1;
                    map.put(ch,nf);
                }
                
                
                if(map.size() == k) {
                    break;
                }
            }
        }
        
        return ans;  
    }
}