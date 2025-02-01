struct Solution;
impl Solution {
    pub fn count_partitions(nums: Vec<i32>) -> i32 {
        let mut sums = vec![0; nums.len() + 1];
        for i in 0..nums.len() {
            sums[i + 1] = nums[i] + sums[i]
        }
        let mut res = 0;
        for i in 0..nums.len() - 1 {
            let diff = sums[nums.len()] - sums[i + 1] * 2;
            if diff % 2 == 0 {
                res += 1;
            }
        }
        res
    }
}
/*
https://leetcode.cn/problems/count-partitions-with-even-sum-difference/description/
给你一个长度为 n 的整数数组 nums 。

分区 是指将数组按照下标 i （0 <= i < n - 1）划分成两个 非空 子数组，其中：

左子数组包含区间 [0, i] 内的所有下标。
右子数组包含区间 [i + 1, n - 1] 内的所有下标。
对左子数组和右子数组先求元素 和 再做 差 ，统计并返回差值为 偶数 的 分区 方案数。



示例 1：

输入：nums = [10,10,3,7,6]

输出：4

解释：

共有 4 个满足题意的分区方案：

[10]、[10, 3, 7, 6] 元素和的差值为 10 - 26 = -16 ，是偶数。
[10, 10]、[3, 7, 6] 元素和的差值为 20 - 16 = 4，是偶数。
[10, 10, 3]、[7, 6] 元素和的差值为 23 - 13 = 10，是偶数。
[10, 10, 3, 7]、[6] 元素和的差值为 30 - 6 = 24，是偶数。
示例 2：

输入：nums = [1,2,2]

输出：0

解释：

不存在元素和的差值为偶数的分区方案。

示例 3：

输入：nums = [2,4,6,8]

输出：3

解释：

所有分区方案都满足元素和的差值为偶数。
 */
