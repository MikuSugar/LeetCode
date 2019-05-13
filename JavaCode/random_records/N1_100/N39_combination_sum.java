package JavaCode.random_records.N1_100;

import java.util.ArrayList;
import java.util.List;

public class N39_combination_sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(res,candidates,target,0,0,new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, int target, int index, int sum, List<Integer> list) {
        if(sum==target)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum>target)return;
        for (int i=index;i<candidates.length;i++)
        {
            list.add(candidates[i]);
            dfs(res,candidates,target,i,sum+candidates[i],list);
            list.remove(list.size()-1);
        }
    }
}
/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
