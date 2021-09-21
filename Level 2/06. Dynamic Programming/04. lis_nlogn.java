class Solution {
    
    //nlogn LIS
    public int lengthOfLIS(int[] nums) {
        int[]dp = new int[nums.length];
        
        ArrayList<Integer>seq = new ArrayList<>();
        
        for(int i=0; i < nums.length;i++) {
            if(seq.size() == 0 || seq.get(seq.size()-1) < nums[i]) {
                seq.add(nums[i]);
            }
            else {
                int ci = findCeil(seq,nums[i]); //ceil idx
                seq.set(ci,nums[i]);
            }
        }
        
        return seq.size();
    }
    
    
    public static int findCeil(ArrayList<Integer>seq,int val) {
        int lo = 0;
        int hi = seq.size();
        int ci = -1;
        
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            
            if(seq.get(mid) == val) {
                //no changes in seq
                ci = mid;
                break;
            }
            else if(seq.get(mid) < val) {
                lo = mid+1;
            }
            else {
                ci = mid;
                hi = mid-1;
            }
        }
        
        return ci;
    }
}