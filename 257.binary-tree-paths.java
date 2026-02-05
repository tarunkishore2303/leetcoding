/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 */

// @lc code=start

import java.util.*;

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root!=null) recur(root,"",ans);
        return ans;
    }

    private void recur(TreeNode root, String path,List<String> ans){
        if(root.left == null && root.right == null) ans.add(path + root.val);
        if(root.left!=null) recur(root.left, path + root.val + "->",ans);
        if(root.right!=null) recur(root.right, path + root.val + "->",ans);
    }
}
// @lc code=end

