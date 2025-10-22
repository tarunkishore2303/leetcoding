/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(),nums,0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int index){
        ans.add(new ArrayList<>(temp));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            backtrack(ans, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
// @lc code=end

