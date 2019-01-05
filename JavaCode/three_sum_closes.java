package JavaCode;

import java.util.Arrays;

public class three_sum_closes {

    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int sum=nums[0]+nums[1]+nums[2];

            /**
             * 排序后选定一个中间值。两个指针开始遍历
             * 中间值i,头m,尾n
             */
            for(int i=1;i<nums.length-1;i++)
            {
                int m=0;
                int n=nums.length-1;
                while (m<i&&n>i)
                {
                    int tempsum=nums[m]+nums[i]+nums[n];
                    if(tempsum==target)
                    {
                        return target;
                    }
                    if(Math.abs(tempsum-target)<Math.abs(sum-target))
                    {
                        System.out.println(sum);
                        sum=tempsum;
                    }

                    if(tempsum<target)
                    {
                        m++;
                    }
                    else
                    {
                        n--;
                    }

                }
            }
            return sum;
        }
    }
}
/**
 * https://leetcode-cn.com/problems/3sum-closest/
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */

