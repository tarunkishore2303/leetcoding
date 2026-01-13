/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recur(root,ans,0);
        return ans;
    }

    private void recur(TreeNode curr, List<Integer> res,int depth){
        if(curr==null){
            return;
        }
        if(depth == res.size()){
            res.add(curr.val);
        }
        recur(curr.right,res,depth+1);
        recur(curr.left,res,depth+1);
    }
}
// @lc code=end

