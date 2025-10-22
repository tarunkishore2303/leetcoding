/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), ans, 0,visited);
        return ans;
    }

    private void backtrack(int[] nums,List<Integer> temp, List<List<Integer>> ans, int index,boolean[] visited){
        if(nums.length == temp.size()){
            ans.add(new ArrayList<>(temp));
        }

        for(int i = 0;i<nums.length;i++){
            if(visited[i]==true) continue;
            if(i>0 && nums[i]==nums[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            temp.add(nums[i]);
            backtrack(nums,temp,ans,i+1,visited);
            visited[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}
// @lc code=end

