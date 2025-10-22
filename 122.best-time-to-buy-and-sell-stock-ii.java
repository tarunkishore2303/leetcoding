/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, buy = 0,sell = 0, profit = 0;
        int n = prices.length - 1;
        while(i<n){
            while(i<n && prices[i] >= prices[i+1]) i++;
            buy =  prices[i];

            while(i<n && prices[i] < prices[i+1]) i++;

            sell = prices[i];

            profit += sell - buy;
        }
        return profit;
    }
}
// @lc code=end

