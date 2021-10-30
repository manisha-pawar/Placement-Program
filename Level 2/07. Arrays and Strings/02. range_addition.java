//https://www.lintcode.com/problem/903/note

public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
     
    public int[] getModifiedArray(int length, int[][] updates) {
        int[]arr = new int[length];

        //impact of queries on arr
        for(int i=0; i < updates.length;i++) {
            int s = updates[i][0];
            int e = updates[i][1];
            int inc = updates[i][2];

            arr[s] += inc;

            if(e + 1 < arr.length)
            arr[e + 1] -= inc;
        }

        //take prefix sum
        int ps = arr[0];

        for(int i=1; i < arr.length;i++) {
            ps += arr[i];
            arr[i] = ps;
        }

        return arr;
    }
}