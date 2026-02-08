/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
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
	Integer prev = null;
    int count = 1, max = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> ans = new ArrayList<>();
        traverse(root,ans);
        int[] res = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    private void traverse(TreeNode root, List<Integer> list){
        if(root == null) return;
        traverse(root.left,list);
        
        if(prev != null){
            if(root.val == prev){
                count++;
            }else{
                count = 1;
            }
        }
        if(count > max){
            max = count;
            list.clear();
            list.add(root.val);
        }else if(count == max){
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right,list);
    }

 }
// @lc code=end

