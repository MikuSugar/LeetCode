package JavaCode.random_records.N401_500;

import java.util.ArrayList;
import java.util.List;

public class N448_find_all_numbers_disappeared_in_an_array {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> list=new ArrayList<>();

            /**
             *  暴力解法
             */
//            int[] book=new int[nums.length+1];
//            for(int i=0;i<nums.length;i++)
//            {
//                book[nums[i]]++;
//            }
//            for(int i=1;i<=nums.length;i++)
//            {
//                if(book[i]==0)
//                {
//                    list.add(i);
//                }
//            }

            /**
             * 不新开数组解法
             * 因为不能新开数组，就要在原数组进行信息的记录
             * 为了保留原有信息的不被破坏，通过相反数的形式来记录信息
             */
            for(int i=0;i<nums.length;i++)
            {
                //出现过的数字
                int temp=Math.abs(nums[i]);

                //出现过的置为负
                nums[temp-1]=-Math.abs(nums[temp-1]);

            }

            /**
             * 遍历处理过的数组
             * 如果出现正数，说明没有出现该位次的数
             */
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]>0)
                {
                    list.add(i+1);
                }
            }

            return list;
        }
    }
}
/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 示例:
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 */
