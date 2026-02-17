/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
 */

// @lc code=start
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
import java.util.*;
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
      Set<Integer> set = new HashSet<>();
      List<TreeNode> ans = new ArrayList<>();
      for(int i: to_delete) set.add(i);
      if(!set.contains(root.val)) ans.add(root);
      dfs(root,ans,set);
      return ans; 
    }

    private TreeNode dfs(TreeNode root, List<TreeNode> ans,Set<Integer> set){
        if(root == null) return null;
        root.left = dfs(root.left,ans,set);
        root.right = dfs(root.right,ans,set);

        if(set.contains(root.val)){
            if(root.left != null) ans.add(root.left);
            if(root.right != null) ans.add(root.right);
            return null;
        }
        return root;

    }
}
// @lc code=end

