/*
 * @lc app=leetcode id=2260 lang=java
 *
 * [2260] Minimum Consecutive Cards to Pick Up
 */

// @lc code=start

import java.util.*;

class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int r = 0; r < cards.length; r++) {
            if (map.containsKey(cards[r])) {
                ans = Math.min(ans, r - map.get(cards[r]) + 1);
            }
            map.put(cards[r],r);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
// @lc code=end
