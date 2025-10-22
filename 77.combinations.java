/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans,new ArrayList<>(),n,k,1);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans,List<Integer> temp, int n, int k, int start){
        if(k == temp.size()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start;i<=n;i++){
            temp.add(i);
            backtrack(ans, temp, n, k, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
// @lc code=end

