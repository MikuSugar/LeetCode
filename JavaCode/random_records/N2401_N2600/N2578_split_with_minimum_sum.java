package JavaCode.random_records.N2401_N2600;

import java.util.Arrays;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/24 14:13
 * @description N2578_split_with_minimum_sum
 */
public class N2578_split_with_minimum_sum {
    public int splitNum(int num) {
        final String str = String.valueOf(num);
        final int[] nums = new int[str.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = str.charAt(i) - '0';
        }

        Arrays.sort(nums);

        final StringBuilder left = new StringBuilder();
        final StringBuilder right = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                left.append(nums[i]);
            } else {
                right.append(nums[i]);
            }
        }

        return Integer.parseInt(left.toString()) + Integer.parseInt(right.toString());

    }
}
/*
给你一个正整数 num ，请你将它分割成两个非负整数 num1 和 num2 ，满足：

num1 和 num2 直接连起来，得到 num 各数位的一个排列。
换句话说，num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数。
num1 和 num2 可以包含前导 0 。
请你返回 num1 和 num2 可以得到的和的 最小 值。

注意：

num 保证没有前导 0 。
num1 和 num2 中数位顺序可以与 num 中数位顺序不同。
 

示例 1：

输入：num = 4325
输出：59
解释：我们可以将 4325 分割成 num1 = 24 和 num2 = 35 ，和为 59 ，59 是最小和。
示例 2：

输入：num = 687
输出：75
解释：我们可以将 687 分割成 num1 = 68 和 num2 = 7 ，和为最优值 75 。
 

提示：

10 <= num <= 109

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/split-with-minimum-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
