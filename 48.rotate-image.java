/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = Math.floor(nums.length/3);
        for(int num:nums){
            map.put(num,map.getOrDefault(num,1)+1);
        }
        for(Map.Entry entry: map.entrySet()){
            if(entry.getValue()>count) ans.add(entry.getKey());
        }
        return ans;
    }
}
// @lc code=end

