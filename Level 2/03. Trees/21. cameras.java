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
    //need -> 0
    //camera -> 1
    //covered -> 2
    
    static int cams = 0;
    public int minCameraCover(TreeNode root) {
        cams = 0;
        int indicator = minCameraHelper(root);
        
        if(indicator == 0) {
            cams++;
        }
        
        return cams;
    }
    
    public int minCameraHelper(TreeNode node) {
        if(node == null) {
            return 2;
        }
        
        int lci = minCameraHelper(node.left); //left child indication
        int rci = minCameraHelper(node.right); //right child indication
        
        //one of the child needs coverage
        if(lci == 0 || rci == 0) {
            cams++; //place a camera on node
            return 1;
        }
        //one of the child has camera
        if(lci == 1 || rci == 1) {
            return 2; //node is covered
        }
        
        return 0; //node need's a camera
    }
             
}