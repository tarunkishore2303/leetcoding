/*
 * @lc app=leetcode id=740 lang=java
 *
 * [740] Delete and Earn
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
       final int[] values = new int[10001];
       for(int num: nums){
        values[num] += num;
       }
       int take = 0, skip = 0;
       for(int num: values){
            int temp = Math.max(take, skip+num);
            skip = take;
            take = temp;
       }
       return take;
    }
}
// @lc code=end

