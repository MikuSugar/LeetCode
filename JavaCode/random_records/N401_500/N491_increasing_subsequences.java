package JavaCode.random_records.N401_500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N491_increasing_subsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(nums,res,0,new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums,List<List<Integer>> res,int index,List<Integer> list)
    {
        if(list.size()>=2)res.add(new ArrayList<>(list));
        Set<Integer> book=new HashSet<>();
        for (int i=index;i<nums.length;i++)
        {
            if(book.contains(nums[i]))continue;
            book.add(nums[i]);
            if(list.size()==0||list.get(list.size()-1)<=nums[i])
            {
                list.add(nums[i]);
                dfs(nums,res,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }
}
/**
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *
 * 示例:
 *
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 *
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 */
