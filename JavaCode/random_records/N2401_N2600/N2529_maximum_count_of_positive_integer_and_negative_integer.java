package JavaCode.random_records.N2401_N2600;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/31 15:11
 * @description N2529_maximum_count_of_positive_integer_and_negative_integer
 */
public class N2529_maximum_count_of_positive_integer_and_negative_integer {
    public int maximumCount(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            count1 += num > 0 ? 1 : 0;
            count2 += num < 0 ? 1 : 0;
        }
        return Math.max(count2, count1);
    }
}
/*
给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。

换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
注意：0 既不是正整数也不是负整数。

 

示例 1：

输入：nums = [-2,-1,-1,1,2,3]
输出：3
解释：共有 3 个正整数和 3 个负整数。计数得到的最大值是 3 。
示例 2：

输入：nums = [-3,-2,-1,0,0,1,2]
输出：3
解释：共有 2 个正整数和 3 个负整数。计数得到的最大值是 3 。
示例 3：

输入：nums = [5,20,66,1314]
输出：4
解释：共有 4 个正整数和 0 个负整数。计数得到的最大值是 4 。
 

提示：

1 <= nums.length <= 2000
-2000 <= nums[i] <= 2000
nums 按 非递减顺序 排列。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
