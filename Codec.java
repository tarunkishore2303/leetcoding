/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String NULL = "X";
    private static final String COMMA = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb); 
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb){
        if(root == null) sb.append(NULL).append();
        else{     
            sb.append(root.val).append(COMMA);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> dq = new LinkedList<>();
        dq.addAll(Arrays.asList(data.split(COMMA)));
        return buildTree(dq);
    }

    private TreeNode buildTree(Deque<String> dq){
        String s = dq.remove();
        if(s.equals(NULL)) return null;
        else{
            TreeNode node = new TreeNode(Integer.valueOf(s));
            node.left = buildTree(dq);
            node.right = buildTree(dq);
            return node;
        } 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

