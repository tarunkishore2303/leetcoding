/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
      List<Integer> res = new LinkedList<>();
      find(root,target);
      dfs(root,target,k,map.get(root),res);
      return res;
    }

    private int find(TreeNode root, TreeNode target){
      if(root == null) return -1;

      if(root == target){
        map.put(root,0);
        return 0;
      }

      int left = find(root.left,target);
      if(left >= 0){
        map.put(root,left + 1);
        return left + 1;  
      }

      int right = find(root.right, target);
      if(right >= 0){
        map.put(root,right + 1);
        return right + 1;
      }
      return -1;
     }

    private void dfs(TreeNode root, TreeNode target, int k,int length,List<Integer> res){
      if(root == null) return;
      if(map.containsKey(root)) length = map.get(root);
      if(length == k) res.add(root.val);
      dfs(root.left,target,k,length+1, res);
      dfs(root.right,target,k,length+1,res);
    }
}
// @lc code=end

