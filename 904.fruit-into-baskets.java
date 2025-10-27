/*
 * @lc app=leetcode id=904 lang=java
 *
 * [904] Fruit Into Baskets
 */
import java.util.*;
// @lc code=start
class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0, i = 0;
        for(int j=0;j<fruits.length;j++){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            while(map.size()>2){
                map.put(fruits[i],map.get(fruits[i])-1);
                if(map.get(fruits[i])==0)map.remove(fruits[i]);
                i++;
            }
            ans = Math.max(ans,j-i+1);
        }
        return ans;
    }
}
// @lc code=end

