/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
class Solution {
    public static class Pair {
        int lzzp; //left zigzag path (node & left child edge included)
        int rzzp; //right zigzag (node & right child edge included)
        int mzzp; //max zigzag path
        
        Pair() {
            
        }
        
        Pair(int lzzp,int rzzp,int mzzp) {
            this.lzzp = lzzp;
            this.rzzp = rzzp;
            this.mzzp = mzzp;
        }
    }
    
    public int longestZigZag(TreeNode root) {
        Pair ans = helper(root);
        
        return ans.mzzp;
    }
    
    public Pair helper(TreeNode node) {
        if(node == null) {
            return new Pair(-1,-1,0);
        }
        
        Pair lcp = helper(node.left);
        Pair rcp = helper(node.right);
        
        Pair np = new Pair();
        
        np.lzzp = lcp.rzzp + 1;
        np.rzzp = rcp.lzzp + 1;
        
        
        np.mzzp = max(np.lzzp,np.rzzp,lcp.mzzp,rcp.mzzp);
        
        return np;
    }
    
    public int max(int a,int b,int c,int d) {
        int c1 = Math.max(a,b);
        int c2 = Math.max(c,d);
        
        return Math.max(c1,c2);
    }
   
}