package JavaCode.random_records.N201_300;

import java.util.ArrayList;
import java.util.List;

public class N216_combination_sum_iii {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        if(k>0&&k<10&&n<=45&&n>0)
            dfs(res,new ArrayList<Integer>(),0,1,k,n);
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> list, int sum, int start,int k,int n) {
        if(list.size()==k)
        {
            if(sum==n)res.add(new ArrayList<>(list));
            return;
        }
        for (int i=start;i<10;i++)
        {
            list.add(i);
            dfs(res,list,sum+i,i+1,k,n);
            list.remove(list.size()-1);
        }
    }
}
/**
 * https://leetcode-cn.com/problems/combination-sum-iii/
 *  找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
