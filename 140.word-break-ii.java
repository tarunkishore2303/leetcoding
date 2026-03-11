/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
import java.util.*;
class Solution {
    Set<String> set;
    Map<Integer,List<String>> map;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.set = new HashSet<>(wordDict);
        this.map = new HashMap<>();
        return solve(0,s);
    }

    private List<String> solve(int i,String s){
        if(map.containsKey(i)) return map.get(i);

        List<String> res = new ArrayList<>();

        if(s.length() == i){
            res.add("");
            return res;
        }

        for(int end = i+1;end<=s.length();end++){
            String word = s.substring(i,end);
            if(set.contains(word)){
                List<String> ans = solve(end,s);
                for(String str: ans){
                    res.add(word + (str.isEmpty() ? "" :" " + str));
                }
            }
        }

        map.put(i,res);
        return res;

    }
}
// @lc code=end

