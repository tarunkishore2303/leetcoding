/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        backtrack(ans, candidates, target, 0, new ArrayList<>(),0);
        return ans;
    }

    private void backtrack(List<List<Integer>> list, int[] nums, int tgt, int sum, List<Integer> tempList, int idx) {
        if(tgt<sum) return;
        if (tgt == sum) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int end = idx; end < nums.length; end++) {
            tempList.add(nums[end]);
            sum=sum+nums[end];
            backtrack(list, nums, tgt, sum, tempList, end);
            tempList.remove(tempList.size()-1);
            sum = sum - nums[end];
        }
    }
}
// @lc code=end
