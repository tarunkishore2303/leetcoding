/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = (int)Math.floor(nums.length / 3);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 1) + 1);
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > count)
                ans.add(entry.getKey());
        }
        return ans;
    }
}
// @lc code=end
