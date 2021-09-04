//https://leetcode.com/problems/group-anagrams/submissions/


//1. hashmap as key
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,ArrayList<String>>map = new HashMap<>(); //fmap vs arraylist
        
        for(int i=0; i < strs.length;i++) {
            String str = strs[i];
            HashMap<Character,Integer>fmap = new HashMap<>();
            
            //create fmap
            for(int j=0; j < str.length();j++) {
                char ch = str.charAt(j);
                
                int nf = fmap.getOrDefault(ch,0) + 1;
                fmap.put(ch,nf);
            }
            
            if(map.containsKey(fmap) == false) {
                ArrayList<String>list = new ArrayList<>();
                list.add(str);
                map.put(fmap,list);
            }
            else {
                ArrayList<String>list = map.get(fmap);
                list.add(str);
            }
        }
        
        
        List<List<String>>ans = new ArrayList<>();
        
        for(HashMap<Character,Integer>key : map.keySet()) {
            ans.add(map.get(key));
        }
        
        return ans;
    }
}


//2. string as key
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>>map=new HashMap<>();
        
        for(int i=0;i<strs.length;i++) {
            String temp=findKey(strs[i]);
            if(map.containsKey(temp) == true) {
                map.get(temp).add(strs[i]);
            }
            else {
                ArrayList<String>ls=new ArrayList<>();
                ls.add(strs[i]);
                map.put(temp,ls);
            }
        }
        
        List<List<String>>ans=new ArrayList<>();
        ArrayList<String>keys=new ArrayList<>(map.keySet());
        
        for(int i=0;i<keys.size();i++) {
            String key=keys.get(i);
            ans.add(map.get(key));
        }
        
        return ans;
    }
    
    public static String findKey(String str) {
        String ans="";
        int[]arr=new int[26];
        
        for(int i=0;i<str.length();i++) {
            char ch=str.charAt(i);
            arr[ch-'a']++;
        }
        
        //construct ans from array
        for(int i=0;i<26;i++) {
            if(arr[i] != 0) {
                char ch=(char)('a'+i);
                String s=""+ch+arr[i];
                ans+=s;
            } 
        }
        
        return ans;
    }
}