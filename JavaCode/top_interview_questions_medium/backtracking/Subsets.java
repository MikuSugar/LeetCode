package JavaCode.top_interview_questions_medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets
{
    public static void main(String[] args)
    {
        int[] t={1,2,3};
        new Subsets().new Solution().subsets(t);
    }
    class Solution {

        private int[] nums;
        private List<List<Integer>> list;
        public List<List<Integer>> subsets(int[] nums) {
            list=new ArrayList<>();
            if(nums.length==0) return list;
            this.nums=nums;
            dfs(0,new ArrayList<>());
            return list;
        }

        /**
         * dfs遍历 两种情况，在或者不在
         * @param index
         * @param list
         */
        void dfs(int index,List<Integer> list)
        {
            this.list.add(new ArrayList<>(list));
            for(int i=index;i<nums.length;i++)
            {
                list.add(nums[i]);
                dfs(i+1,list);
                list.remove(list.size()-1);
            }

        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/94/
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
