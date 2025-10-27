/*
 * @lc app=leetcode id=1716 lang=java
 *
 * [1716] Calculate Money in Leetcode Bank
 */

// @lc code=start
class Solution {
    public int totalMoney(int n) {
        int sum = 0;
        int startIdx = 1;
        while(n>0){
            for(int i=startIdx;i<=startIdx+6;i++){
                sum+=i;n--;
                if(n==0) return sum;
            }
            startIdx++;
        }
        return sum;
    }
}
// @lc code=end

