/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2){
            return nums.length;
        }
        int j = 2, n = nums.length;
        for(int i=2;i<nums.length;i+=2){
            j = i+1;
            while(j<n && nums[i]==nums[j]) j++;
            nums[j] = nums[i];
        }
        return j;
    }
}
// @lc code=end

