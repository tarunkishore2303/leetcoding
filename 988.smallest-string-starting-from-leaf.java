/*
 * @lc app=leetcode id=988 lang=java
 *
 * [988] Smallest String Starting From Leaf
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
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        dfs(root, new StringBuilder(),ans);
        return ans.toString();
    }

    private void dfs(TreeNode root, StringBuilder temp, StringBuilder ans){
        if(root == null) return;
        temp.append((char)('a' + root.val));

        if(root.left == null && root.right == null){
            String c = temp.reverse().toString();
            if(ans.length() == 0 || c.compareTo(ans.toString())<0){
                ans.setLength(0);
                ans.append(c);
            }
            temp.reverse();
        }

        dfs(root.left,temp,ans);
        dfs(root.right,temp,ans);

        temp.setLength(temp.length()-1);
    }
}
// @lc code=end

