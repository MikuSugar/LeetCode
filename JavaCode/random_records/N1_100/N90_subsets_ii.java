package JavaCode.random_records.N1_100;

import java.util.*;

public class N90_subsets_ii
{
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        dfs(res,nums,0,new boolean[nums.length],new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int start, boolean[] book, List<Integer> list)
    {
        res.add(new ArrayList<>(list));
        for (int i=start;i<nums.length;i++)
        {
            if(i!=0&&nums[i]==nums[i-1]&&!book[i-1])continue;
            book[i]=true;
            list.add(nums[i]);
            dfs(res,nums,i+1,book,list);
            book[i]=false;
            list.remove(list.size()-1);
        }
    }


}
/**
 *给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
