package JavaCode.random_records.N2401_N2600;

import utils.Parse;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/27 14:47
 * @description N2447_number_of_subarrays_with_gcd_equal_to_k
 */
public class N2447_number_of_subarrays_with_gcd_equal_to_k {

    public static void main(String[] args) {
        System.out.println(new N2447_number_of_subarrays_with_gcd_equal_to_k().subarrayGCD(
                Parse.toIntArr("[9,3,1,2,6,3]"), 3));
        System.out.println(new N2447_number_of_subarrays_with_gcd_equal_to_k().subarrayGCD(
                Parse.toIntArr("[4]"), 7));
        System.out.println(new N2447_number_of_subarrays_with_gcd_equal_to_k().subarrayGCD(
                Parse.toIntArr("[3,3,4,1,2]"), 1));
    }

    public int subarrayGCD(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k != 0) {
                continue;
            }
            int curGcd = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % k != 0) {
                    break;
                }
                curGcd = gcd(curGcd, nums[j]);
                if (curGcd == k) {
                    res++;
                }
            }
        }
        return res;
    }


    private static int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}
/*
给你一个整数数组 nums 和一个整数 k ，请你统计并返回 nums 的子数组中元素的最大公因数等于 k 的子数组数目。

子数组 是数组中一个连续的非空序列。

数组的最大公因数 是能整除数组中所有元素的最大整数。

 

示例 1：

输入：nums = [9,3,1,2,6,3], k = 3
输出：4
解释：nums 的子数组中，以 3 作为最大公因数的子数组如下：
- [9,3,1,2,6,3]
- [9,3,1,2,6,3]
- [9,3,1,2,6,3]
- [9,3,1,2,6,3]
示例 2：

输入：nums = [4], k = 7
输出：0
解释：不存在以 7 作为最大公因数的子数组。
 

提示：

1 <= nums.length <= 1000
1 <= nums[i], k <= 109


来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/number-of-subarrays-with-gcd-equal-to-k
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
