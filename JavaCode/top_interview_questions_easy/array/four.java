package JavaCode.top_interview_questions_easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class four {
    public boolean containsDuplicate(int[] nums) {
       //return  fun0(nums);
        return fun1(nums);
    }

    /**
     * 利用HashMap来判断
     * @param nums
     * @return
     */
    boolean fun0(int[] nums)
    {
        Map<Integer,Integer> map=new HashMap<>();
        boolean flag=false;

        for(int i:nums)
        {
            if(map.containsKey(i))
            {
                flag=true;
                break;
            }
            else
            {
                map.put(i,0);
            }
        }

        return flag;
    }

    /**
     * 利用排序
     * @param nums
     * @return
     */
    boolean fun1(int[] nums)
    {
        Arrays.sort(nums);

        if(nums.length==0||nums.length==1)
        {
            return false;
        }

        int temp=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==temp)
            {
                return true;
            }
            temp=nums[i];
        }
        return false;
    }

}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
