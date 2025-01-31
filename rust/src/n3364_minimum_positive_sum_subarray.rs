use std::cmp;
pub struct Solution;
impl Solution {
    pub fn minimum_sum_subarray(nums: Vec<i32>, l: i32, r: i32) -> i32 {
        let len = nums.len() as i32;
        if len < l {
            return -1;
        }
        let mut sums = vec![0; nums.len() + 1];
        for i in 0..nums.len() {
            sums[i + 1] = sums[i] + nums[i];
        }
        let mut min = i32::MAX;
        for i in 0..(len - l + 1) {
            for j in (i + l)..cmp::min(i + r + 1, len + 1) {
                let n = sums[j as usize] - sums[i as usize];
                if n > 0 {
                    min = cmp::min(n, min);
                }
            }
        }
        if min == i32::MAX {
            -1
        } else {
            min
        }
    }
}
/*
https://leetcode.cn/problems/minimum-positive-sum-subarray/description/
给你一个整数数组 nums 和 两个 整数 l 和 r。你的任务是找到一个长度在 l 和 r 之间（包含）且和大于 0 的 子数组 的 最小 和。

返回满足条件的子数组的 最小 和。如果不存在这样的子数组，则返回 -1。

子数组 是数组中的一个连续 非空 元素序列。



示例 1：

输入： nums = [3, -2, 1, 4], l = 2, r = 3

输出： 1

解释：

长度在 l = 2 和 r = 3 之间且和大于 0 的子数组有：

[3, -2] 和为 1
[1, 4] 和为 5
[3, -2, 1] 和为 2
[-2, 1, 4] 和为 3
其中，子数组 [3, -2] 的和为 1，是所有正和中最小的。因此，答案为 1。

示例 2：

输入： nums = [-2, 2, -3, 1], l = 2, r = 3

输出： -1

解释：

不存在长度在 l 和 r 之间且和大于 0 的子数组。因此，答案为 -1。

示例 3：

输入： nums = [1, 2, 3, 4], l = 2, r = 4

输出： 3

解释：

子数组 [1, 2] 的长度为 2，和为 3，是所有正和中最小的。因此，答案为 3。
 */
