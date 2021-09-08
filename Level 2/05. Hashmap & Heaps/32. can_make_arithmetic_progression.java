class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        
        HashSet<Integer>hs = new HashSet<>();
        
        for(int val : arr) {
            if(val < min) {
                smin = min;
                min = val;
            }
            else if(val < smin) {
                smin = val;
            }
            hs.add(val);
        }
        
        int cd = smin - min;
        
        if(cd == 0 && hs.size() == 1) {
            return true;
        }
        else if(cd == 0)  {
            return false;
        }
        
        for(int i = 0; i < arr.length;i++) {
            int val = min + cd*i;
            
            if(hs.contains(val) == false) {
                return false;
            }
        }
        
        return true;
        
    
    }
}