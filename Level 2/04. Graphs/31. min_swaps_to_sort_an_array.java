// https://practice.geeksforgeeks.org/problems/minimum-swaps/1

class Solution
{
    
    static class Pair{
        int val;
        int idx;
        
        Pair() {
            
        }
        
        Pair(int val,int idx) {
            this.val = val;
            this.idx = idx;
        }
        
    }
    
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int n = nums.length;
        Pair[]arr = new Pair[n];
        
        for(int i=0; i < n;i++) {
            arr[i] = new Pair(nums[i],i);
        }
        
        Arrays.sort(arr,(a,b)-> {
            return a.val - b.val;
        });
        
        
        int minopr = 0;
        
        boolean[]vis = new boolean[n];
        
        for(int i=0; i < n;i++) {
            if(vis[i] == true || i == arr[i].idx) {
                continue;
            }
            
            int k = i;
            vis[k] = true;
            int count = 1;
            
            while(true) {
                k = arr[k].idx;
                
                if(vis[k] == true) {
                    break;
                }
                
                count++;
                vis[k] = true;
            }
            
            minopr += (count - 1);
        }
        
        return minopr;
        
    }
 
}