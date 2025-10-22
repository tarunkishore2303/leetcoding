/*
 * @lc app=leetcode id=541 lang=java
 *
 * [541] Reverse String II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int i = 0;
        while(i<n-1){
            reverse(chars,i,Math.min(i+k-1,n-1));
            i+= 2*k;
        }
        return new String(chars);
    }
    private void reverse(char[] chars,int start,int end){
        while(start<end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;end--;
        }
    }
}
// @lc code=end

