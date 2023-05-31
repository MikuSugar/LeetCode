package JavaCode.contest.weekly.n201_300.n280;


import utils.Parse;

/**
 * @author mikusugar
 */
public class N4 {
    public static void main(String[] args) {
        System.out.println(new N4().maximumANDSum(
                Parse.toIntArr("[1,3,10,4,7,1]"),9

        ));
    }
    public int maximumANDSum(int[] nums, int numSlots) {
        int res = 0;
        int[] dp = new int[1 << (2 * numSlots)];
        for (int i = 0; i < dp.length; i++) {
            if (Integer.bitCount(i) >= nums.length) continue;
            for (int k = 0; k < numSlots * 2; k++) {
                if ((i & (1 << k)) == 0) {
                    int next = i | 1 << k;
                    dp[next] = Math.max(dp[next], dp[i] + ((k / 2 + 1) & nums[Integer.bitCount(i)]));
                    res = Math.max(dp[next], res);
                }
            }
        }
        return res;
    }
}
/*
给你一个长度为 n 的整数数组 nums 和一个整数 numSlots ，满足2 * numSlots >= n 。总共有 numSlots 个篮子，编号为 1 到 numSlots 。

你需要把所有 n 个整数分到这些篮子中，且每个篮子 至多 有 2 个整数。一种分配方案的 与和 定义为每个数与它所在篮子编号的 按位与运算 结果之和。

比方说，将数字 [1, 3] 放入篮子 1 中，[4, 6] 放入篮子 2 中，这个方案的与和为 (1 AND 1) + (3 AND 1) + (4 AND 2) + (6 AND 2) = 1 + 1 + 0 + 2 = 4 。
请你返回将 nums 中所有数放入 numSlots 个篮子中的最大与和。



示例 1：

输入：nums = [1,2,3,4,5,6], numSlots = 3
输出：9
解释：一个可行的方案是 [1, 4] 放入篮子 1 中，[2, 6] 放入篮子 2 中，[3, 5] 放入篮子 3 中。
最大与和为 (1 AND 1) + (4 AND 1) + (2 AND 2) + (6 AND 2) + (3 AND 3) + (5 AND 3) = 1 + 0 + 2 + 2 + 3 + 1 = 9 。
示例 2：

输入：nums = [1,3,10,4,7,1], numSlots = 9
输出：24
解释：一个可行的方案是 [1, 1] 放入篮子 1 中，[3] 放入篮子 3 中，[4] 放入篮子 4 中，[7] 放入篮子 7 中，[10] 放入篮子 9 中。
最大与和为 (1 AND 1) + (1 AND 1) + (3 AND 3) + (4 AND 4) + (7 AND 7) + (10 AND 9) = 1 + 1 + 3 + 4 + 7 + 8 = 24 。
注意，篮子 2 ，5 ，6 和 8 是空的，这是允许的。


提示：

n == nums.length
1 <= numSlots <= 9
1 <= n <= 2 * numSlots
1 <= nums[i] <= 15
 */
