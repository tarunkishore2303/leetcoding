/*
 * @lc app=leetcode id=2559 lang=java
 *
 * [2559] Count Vowel Strings in Ranges
 */

// @lc code=start
class Solution {
    private boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    private boolean vowelWord(String word) {
        return (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1)));
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length];
        for(int i=0;i<words.length;i++){
            if(vowelWord(words[i])){
                prefix[i]++;
            }
        }
        for(int i = 1;i<words.length;i++){
            prefix[i] = prefix[i] + prefix[i-1];
        }

        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l = queries[i][0], r = queries[i][1];
            if(l==0){
                ans[i] = prefix[r];
            }else{
                ans[i] = prefix[r] - prefix[l-1];
            }
        }
        return ans;

    }
}
// @lc code=end
