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
    
    public static class Pair implements Comparable<Pair>{
        TreeNode node;
        int x;
        int y;
        
        Pair(TreeNode node,int x,int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
        
        Pair() {
            
        }
        

        //this < other -> -ve
        //this > other -> +ve
        //this == other -> 0
        public int compareTo(Pair o) {
            if(this.y != o.y) {
                return this.y - o.y;
            }
            else if(this.x != o.x) {
                return this.x - o.x;
            }
            else {
                return this.node.val - o.node.val;
            }
        }
    }

    public void width(TreeNode root,int hl,int[]mmhl) {
        
        if(root == null) {
            return;
        }
        
        mmhl[0] = Math.min(mmhl[0],hl);  //minhl
        mmhl[1] = Math.max(mmhl[1],hl); //maxhl
        
        width(root.left,hl-1,mmhl);
        width(root.right,hl+1,mmhl);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        List<List<Integer>>ans = new ArrayList<>();
        
        int[]minmaxhl = new int[2];
        width(root,0,minmaxhl);
        
        int minhl = minmaxhl[0];
        int maxhl = minmaxhl[1];
        
        int w = maxhl - minhl + 1;
        
        for(int i=0; i < w;i++) {
            ans.add(new ArrayList<>());
        }
        
        int blev = -minhl;
        
        pq.add(new Pair(root,blev,0));
        
        while(pq.size() > 0) {
            //remove
            Pair rem = pq.remove();
            
            //work
            ans.get(rem.x).add(rem.node.val);
            
            //add children
            if(rem.node.left != null) {
                pq.add(new Pair(rem.node.left,rem.x-1,rem.y+1));    
            }
            if(rem.node.right != null) {
                 pq.add(new Pair(rem.node.right,rem.x+1,rem.y+1));    
            }
        }
        
        return ans;
    }
}