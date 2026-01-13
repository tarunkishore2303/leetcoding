/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            
            while(!stack1.isEmpty()){
                TreeNode node = stack1.pop();
                temp.add(node.val);
                if(node.left != null)stack2.add(node.left);
                if(node.right != null)stack2.add(node.right);

            }
            ans.add(temp);
            temp = new ArrayList<>();
            while(!stack2.isEmpty()){
                TreeNode node = stack2.pop();
                temp.add(node.val);
                if(node.right != null)stack1.add(node.right);
                if(node.left != null)stack1.add(node.left);

            }
            if(!temp.isEmpty()) ans.add(temp);
        }
        return ans;
    }
}
// @lc code=end

