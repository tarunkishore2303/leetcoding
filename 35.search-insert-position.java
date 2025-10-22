/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if(target > nums[right]) return right;
        while(left <= right){
            int mid = (left + right) /2 ;
            if(target == nums[mid]){
                return mid;
            }
            if(target < nums[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end

