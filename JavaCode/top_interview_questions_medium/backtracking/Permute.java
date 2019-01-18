package JavaCode.top_interview_questions_medium.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Permute
{

    class Solution
    {
        private List<List<Integer>> list;
        private int[] nums;
        private int[] book;//标记数组
        public List<List<Integer>> permute(int[] nums)
        {
            list=new ArrayList<>();
            if(nums.length==0) return list;
            this.nums=nums;
            this.book=new int[nums.length];
            fun(new ArrayList<>());
            return list;
        }

        void fun(List<Integer> list){
            if(list.size()==nums.length)
            {
                List<Integer> list1=new ArrayList<>();
                for(int i:list)
                {
                    list1.add(i);
                }

                this.list.add(list1);
                return;
            }
            for(int i=0;i<nums.length;i++)
            {
                if(book[i]==0)
                {
                    list.add(nums[i]);
                    book[i]=1;
                    fun(list);
                    book[i]=0;
                    list.remove(list.size()-1);
                }
            }

        }

    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/93/
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
