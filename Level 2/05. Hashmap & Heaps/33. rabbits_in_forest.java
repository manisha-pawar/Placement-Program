class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer>map = new HashMap<>(); //ans vs rabbit count
        
        for(int i =0 ; i < answers.length;i++) {
            int nf = map.getOrDefault(answers[i],0) + 1;
            map.put(answers[i],nf);
        }
        
        
        int mr = 0; //min rabbits
        
        for(int key : map.keySet()) {
            int val = map.get(key);
            int gc = key + 1;
            
            mr += gc * Math.ceil(val*1.0 / gc);
        }
        
        return mr;
    }
}