struct Solution;
impl Solution {
    pub fn max_count(m: i32, n: i32, ops: Vec<Vec<i32>>) -> i32 {
        let mut m = m;
        let mut n = n;
        for op in ops {
            m = std::cmp::min(m, op[0]);
            n = std::cmp::min(n, op[1]);
        }
        m * n
    }
}
/*
https://leetcode.cn/problems/range-addition-ii/?envType=daily-question&envId=2025-02-02
给你一个 m x n 的矩阵 M 和一个操作数组 op 。矩阵初始化时所有的单元格都为 0 。ops[i] = [ai, bi] 意味着当所有的 0 <= x < ai 和 0 <= y < bi 时， M[x][y] 应该加 1。

在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。



示例 1:



输入: m = 3, n = 3，ops = [[2,2],[3,3]]
输出: 4
解释: M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
示例 2:

输入: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
输出: 4
示例 3:

输入: m = 3, n = 3, ops = []
输出: 9

 */
