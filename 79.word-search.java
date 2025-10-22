/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(word, board, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(String word, char[][] board, int i, int j, int idx) {
        if (idx == word.length())
            return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;
        if (board[i][j] != word.charAt(idx))
            return false;
        board[i][j] ^= 256;
        boolean ans = dfs(word, board, i + 1, j, idx + 1) ||
                dfs(word, board, i - 1, j, idx + 1) || dfs(word, board, i, j + 1, idx + 1)
                || dfs(word, board, i, j - 1, idx + 1);
        board[i][j] ^= 256;
        return ans;
    }
}
// @lc code=end
