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
        int incMP = 0; //included in robbery
        int excMP = 0; //excluded from robbery
        
        Pair() {
            
        }
        
        Pair(int incMP,int excMP) {
            this.incMP = incMP;
            this.excMP = excMP;
        }
    }
    
    public int rob(TreeNode root) {
        Pair ans = rob_helper(root);
        
        int maxProfit = Math.max(ans.incMP,ans.excMP);
        return maxProfit;
    }
    
    public Pair rob_helper(TreeNode node) {
        if(node == null) {
            return new Pair(0,0);
        }
        
        Pair lcp = rob_helper(node.left);
        Pair rcp = rob_helper(node.right);
        
        int incMP = lcp.excMP + rcp.excMP + node.val;
        int excMP = Math.max(lcp.incMP,lcp.excMP) + Math.max(rcp.incMP,rcp.excMP);
        
        Pair np = new Pair(incMP,excMP);
        return np;
    }
}
    