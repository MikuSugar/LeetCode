package JavaCode.array_and_string.two_pointer_technique;

public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int temp_max=0;
        for(int i:nums)
        {
            if(i==1)
            {
                temp_max++;
            }
            else
            {
                max=Math.max(temp_max,max);
                temp_max=0;
            }
        }

        return Math.max(max,temp_max);
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/array-and-string/201/two-pointer-technique/788/
 * 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
