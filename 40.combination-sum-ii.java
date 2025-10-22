/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans,new ArrayList<>(),candidates,target,0,0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> temp,int[] nums, int target, int sum, int idx){
        if(sum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(sum > target) return;

        for(int i = idx;i<nums.length;i++){
            if(i != idx && nums[i] == nums[i-1]) continue;
            sum = sum + nums[i];
            temp.add(nums[i]);
            backtrack(ans, temp, nums, target, sum, i+1);
            sum = sum - nums[i];
            temp.remove(temp.size()-1);
        }
    }
}
// @lc code=end

