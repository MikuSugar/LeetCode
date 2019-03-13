package JavaCode.random_records.N1_100;

import java.util.*;

public class N47_permutations_ii {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null||nums.length==0)return res;

        Map<Integer,Integer> map=new HashMap<>();
        for (int i:nums)map.put(i,map.getOrDefault(i,0)+1);

        dfs(res,map,new LinkedList<Integer>(),nums.length);
        return res;
    }

    private void dfs(List<List<Integer>> res, Map<Integer, Integer> map, LinkedList<Integer> list, int length)
    {
        if(list.size()==length)
        {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int key:map.keySet())
        {
            int cnt=map.get(key);
            if(cnt==0)continue;
            map.put(key,cnt-1);
            list.add(key);
            dfs(res,map,list,length);
            list.removeLast();
            map.put(key,cnt);
        }
    }


}
/**
 * https://leetcode-cn.com/problems/permutations-ii/
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
