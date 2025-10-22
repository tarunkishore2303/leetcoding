/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int zero = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==0){
                zero=i;
            }else{
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
            }
        }

    }
}
// @lc code=end

