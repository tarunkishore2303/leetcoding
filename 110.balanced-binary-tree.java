/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int height(TreeNode root){
        if(root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight =  height(root.right);

        if(rightHeight == -1 || leftHeight == -1) return -1;

        if(Math.abs(leftHeight - rightHeight) > 1 ) return -1;
        
        return Math.max(rightHeight, leftHeight) + 1;
    }
    public boolean isBalanced(TreeNode root) {
       if(root == null) return true;
       if(height(root) == -1) return false;
       ;
                
    }
}
// @lc code=end

