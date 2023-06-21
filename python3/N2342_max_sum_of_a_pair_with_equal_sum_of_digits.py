from typing import List


class n2342:
    def maximumSum(self, nums: List[int]) -> int:
        d = {}
        res = -1
        for num in nums:
            s = 0
            n = num
            while n != 0:
                s += n % 10
                n //= 10
            if s not in d:
                d[s] = num
            else:
                res = max(res, d[s] + num)
                d[s] = max(d[s], num)
        return res


s = n2342()
assert s.maximumSum([18, 36, 43, 13, 7]) == 54
# 给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与  nums[j] 的数位和相等。
#
# 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
#
#  
#
# 示例 1：
#
# 输入：nums = [18,43,36,13,7]
# 输出：54
# 解释：满足条件的数对 (i, j) 为：
# - (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
# - (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
# 所以可以获得的最大和是 54 。
# 示例 2：
#
# 输入：nums = [10,12,19,14]
# 输出：-1
# 解释：不存在满足条件的数对，返回 -1 。
#  
#
# 提示：
#
# 1 <= nums.length <= 105
# 1 <= nums[i] <= 109
#
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/max-sum-of-a-pair-with-equal-sum-of-digits
#     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
