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
    public class Pair {
        int r2nmps; //root to node max path sum
        int n2nmps; //node to node max path sum
        
        Pair() {
            
        }
        
        Pair(int r2nmps,int n2nmps) {
            this.r2nmps = r2nmps;
            this.n2nmps = n2nmps;
        }
    }
    
    public int maxPathSum(TreeNode root) {
        Pair rp = helper(root);
        return rp.n2nmps;
    }
    
    public int max(int...arr) {
        
        int omax = Integer.MIN_VALUE;
        
        for(int val : arr) {
            if(val > omax) {
                omax = val;
            }
        }
        
        return omax;
    }
    
    public Pair helper(TreeNode root) {
        if(root == null) {
            return new Pair(0,Integer.MIN_VALUE);
        }
        else if(root.left == null && root.right == null) {
            return new Pair(root.val,root.val);
        }
        
        Pair lp = helper(root.left);
        Pair rp = helper(root.right);
        
        int f1 = root.val + lp.r2nmps; //root to left sub-tree node max path sum
        int f2 = root.val + rp.r2nmps; //root right sub-tree node max path sum
        int f3 = lp.r2nmps + root.val + rp.r2nmps; //left sub-tree node to right sub-tree node
        int f4 = root.val; 
        
        int r2n = max(f1,f2,f4);
        int n2n = max(f1,f2,f3,f4,lp.n2nmps,rp.n2nmps);
        
        return new Pair(r2n,n2n);
    }
      
}