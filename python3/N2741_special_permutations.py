from typing import List


class N2741_special_permutations:
    mod = 1e9 + 7
    target = 0

    def specialPerm(self, nums: List[int]) -> int:
        for i in range(0, len(nums)):
            self.target = 1 << i | self.target
        result = 0
        dp = {}
        for i in range(0, len(nums)):
            result += self.dfs(i, 0, nums, dp)
            result %= self.mod
        return int(result)

    def dfs(self, i: int, state: int, nums: List[int], dp: dict) -> int:
        state = (1 << i) | state
        state = state & self.target
        state = (1 << i + 15) | state

        if state & self.target == self.target:
            return 1
        if state in dp:
            return dp[state]

        result = 0
        for ni in range(0, len(nums)):
            if ni == i:
                continue
            if (1 << ni) & state == (1 << ni):
                continue
            if nums[i] % nums[ni] == 0 or nums[ni] % nums[i] == 0:
                result += self.dfs(ni, state, nums, dp)
                result %= self.mod
        dp[state] = result
        return result


algo = N2741_special_permutations()
assert algo.specialPerm([2, 3, 6]) == 2
assert algo.specialPerm([1, 4, 3]) == 2

"""
给你一个下标从 0 开始的整数数组 nums ，它包含 n 个 互不相同 的正整数。如果 nums 的一个排列满足以下条件，我们称它是一个特别的排列：

对于 0 <= i < n - 1 的下标 i ，要么 nums[i] % nums[i+1] == 0 ，要么 nums[i+1] % nums[i] == 0 。
请你返回特别排列的总数目，由于答案可能很大，请将它对 109 + 7 取余 后返回。



示例 1：

输入：nums = [2,3,6]
输出：2
解释：[3,6,2] 和 [2,6,3] 是 nums 两个特别的排列。
示例 2：

输入：nums = [1,4,3]
输出：2
解释：[3,1,4] 和 [4,1,3] 是 nums 两个特别的排列。


提示：

2 <= nums.length <= 14
1 <= nums[i] <= 109
"""
