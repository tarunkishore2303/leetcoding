/*
 * @lc app=leetcode id=2586 lang=java
 *
 * [2586] Count the Number of Vowel Strings in Range
 */

// @lc code=start
class Solution {
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            char startChar = words[i].charAt(0);
            char endChar = words[i].charAt(words[i].length() - 1);
            if (isVowel(startChar) && isVowel(endChar))
                ans++;
        }
        return ans;
    }
}
// @lc code=end
