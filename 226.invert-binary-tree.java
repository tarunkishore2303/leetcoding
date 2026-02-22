/*
p * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert 
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            TreeNode left = temp.left;
            temp.left = temp.right;
            temp.right = left;

            if (temp.left != null) {
                q.offer(temp.left);
            }

            if (temp.right != null) {
                q.offer(temp.right);
            }
        }
        return root;
    }
}
// @lc code=end
