//https://www.lintcode.com/problem/883/

public class Solution {
    /**
     * @param nums: a list of integer
     * @return: return a integer, denote  the maximum number of consecutive 1s
     */
     
    public int findMaxConsecutiveOnes(int[] nums) {
        // write your code here

        int i = -1;
        int j = -1;
        int cz = 0;
        int ans = 0;

        while(i <  nums.length-1) {
            //aquire
            while(i < nums.length-1) {
                i++;
                
                if(nums[i] == 0) {
                    cz++;
                }

                if(cz <= 1) {
                    int len = i - j;
                    ans = Math.max(ans,len);
                }
                else {
                    //invalid
                    break;
                }

            }

            //release
            while(j < i && cz > 1) {
                j++;

                if(nums[j] == 0) {
                    cz--;
                }
            }
        }

        return ans;
    }
}