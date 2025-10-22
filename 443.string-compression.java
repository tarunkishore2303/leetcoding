/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        int track = 0, i = 0;
        int n = chars.length;
        while(i<n){
            char currentChar = chars[i];
            int count = 0;
            while(i< n && chars[i]==currentChar){
                count++;i++;
            }
            chars[track++] = currentChar;
            if(count !=1 ){
                for(char c: Integer.toString(count).toCharArray()){
                    chars[track++] = c;
                }
            }
        
        }
        return track;
        
    }
}
// @lc code=end

