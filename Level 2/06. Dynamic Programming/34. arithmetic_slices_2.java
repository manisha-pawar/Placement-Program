//https://leetcode.com/problems/arithmetic-slices-ii-subsequence/

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        HashMap < Long, Integer > [] dp = new HashMap[nums.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashMap < > ();
        }

        int oans = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                long d = (long) nums[i] - (long) nums[j];

                int vj = dp[j].getOrDefault(d, 0);
                int vi = dp[i].getOrDefault(d, 0);

                oans += vj;

                dp[i].put(d, vj + vi + 1);
            }
        }

        return oans;
    }
}