/*
 * @lc app=leetcode id=1161 lang=java
 *
 * [1161] Maximum Level Sum of a Binary Tree
 */

// @lc code=start

import java.util.*;

// import javax.swing.tree.TreeNode;



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
    public int maxLevelSum(TreeNode root) {
        if(root==null) return 0;
        return dfs(root);
    }

    private int dfs(TreeNode root){
        int maxSum = Integer.MIN_VALUE, ans = 1, level = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int currSum = 0;
            int n = q.size();
            for(int i = 0;i<q.size();i++){
                TreeNode curr = q.poll();
                currSum += curr.val;
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            if(currSum>maxSum){
                ans = level;
                maxSum = currSum;    
            }
            level++;
        }
        return ans;
    }
}
// @lc code=end

