/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low<high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>=nums[low]){
                //shift range to first half
               if(target>=nums[low] && target<nums[mid]){
                    high = mid - 1;
               }else{
                    low = mid + 1;
               }
            }else{
                //shift range to second half
                if(target>nums[mid] && target<=nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return nums[low] == target ? low : -1;
    }
}
// @lc code=end

