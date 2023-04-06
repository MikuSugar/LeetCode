package JavaCode.random_records.N2401_N2600;

import utils.CheckUtil;
import utils.Parse;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/31 14:52
 * @description N2527_find_xor_beauty_of_array
 */
public class N2527_find_xor_beauty_of_array {
    public static void main(String[] args) {
        final N2527_find_xor_beauty_of_array algo = new N2527_find_xor_beauty_of_array();
        CheckUtil.check(algo.xorBeauty(Parse.parseToIntArray("[1,4]")), 5);
        CheckUtil.check(algo.xorBeauty(Parse.parseToIntArray("[15,45,20,2,34,35,5,44,32,30]")), 34);
    }

    public int xorBeauty(int[] nums) {
        int res = 0;
        for (int num : nums) res ^= num;
        return res;
    }
}
/*
给你一个下标从 0 开始的整数数组 nums 。

三个下标 i ，j 和 k 的 有效值 定义为 ((nums[i] | nums[j]) & nums[k]) 。

一个数组的 xor 美丽值 是数组中所有满足 0 <= i, j, k < n  的三元组 (i, j, k) 的 有效值 的异或结果。

请你返回 nums 的 xor 美丽值。

注意：

val1 | val2 是 val1 和 val2 的按位或。
val1 & val2 是 val1 和 val2 的按位与。
 

示例 1：

输入：nums = [1,4]
输出：5
解释：
三元组和它们对应的有效值如下：
- (0,0,0) 有效值为 ((1 | 1) & 1) = 1
- (0,0,1) 有效值为 ((1 | 1) & 4) = 0
- (0,1,0) 有效值为 ((1 | 4) & 1) = 1
- (0,1,1) 有效值为 ((1 | 4) & 4) = 4
- (1,0,0) 有效值为 ((4 | 1) & 1) = 1
- (1,0,1) 有效值为 ((4 | 1) & 4) = 4
- (1,1,0) 有效值为 ((4 | 4) & 1) = 0
- (1,1,1) 有效值为 ((4 | 4) & 4) = 4
数组的 xor 美丽值为所有有效值的按位异或 1 ^ 0 ^ 1 ^ 4 ^ 1 ^ 4 ^ 0 ^ 4 = 5 。
示例 2：

输入：nums = [15,45,20,2,34,35,5,44,32,30]
输出：34
解释：数组的 xor 美丽值为 34 。
 

提示：

1 <= nums.length <= 105
1 <= nums[i] <= 109


来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/find-xor-beauty-of-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
