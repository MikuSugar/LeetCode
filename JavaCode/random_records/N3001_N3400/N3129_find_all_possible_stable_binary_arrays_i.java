package JavaCode.random_records.N3001_N3400;

import utils.CheckUtil;

import java.util.Arrays;

/**
 * @author mikusugar
 * @version 1.0, 2024/8/6 下午4:16
 * @description N3129_find_all_possible_stable_binary_arrays_i
 */
public class N3129_find_all_possible_stable_binary_arrays_i {

    public static void main(String[] args) {
        CheckUtil.check(2, new N3129_find_all_possible_stable_binary_arrays_i().numberOfStableArrays(1, 1, 2));
        CheckUtil.check(1, new N3129_find_all_possible_stable_binary_arrays_i().numberOfStableArrays(1, 2, 1));
        CheckUtil.check(14, new N3129_find_all_possible_stable_binary_arrays_i().numberOfStableArrays(3, 3, 2));
        CheckUtil.check(207227572, new N3129_find_all_possible_stable_binary_arrays_i().numberOfStableArrays(39, 20, 18));
    }

    private final static int MOD = 1000000007;
    private long[][][] dp;
    private int limit;

    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new long[zero + 1][one + 1][2];
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        this.limit = limit;
        return (int) ((dfs(zero, one, 0) + dfs(zero, one, 1)) % MOD);
    }

    private long dfs(int zero, int one, int next) {
        if (zero == 0) {
            if (next == 1 && one <= limit) {
                return 1;
            }
            return 0;
        }
        if (one == 0) {
            if (next == 0 && zero <= limit) {
                return 1;
            }
            return 0;
        }
        if (dp[zero][one][next] != -1) {
            return dp[zero][one][next];
        }
        long result;
        if (next == 0) {
            result = dfs(zero - 1, one, 0) + dfs(zero - 1, one, 1);
            if (zero - limit > 0) {
                result -= dfs(zero - limit - 1, one, 1);
                result += MOD;
            }
        } else {
            result = dfs(zero, one - 1, 0) + dfs(zero, one - 1, 1);
            if (one - limit > 0) {
                result -= dfs(zero, one - limit - 1, 0);
                result += MOD;
            }
        }
        return dp[zero][one][next] = result % MOD;
    }
}
/*
给你 3 个正整数 zero ，one 和 limit 。

一个
二进制数组
 arr 如果满足以下条件，那么我们称它是 稳定的 ：

0 在 arr 中出现次数 恰好 为 zero 。
1 在 arr 中出现次数 恰好 为 one 。
arr 中每个长度超过 limit 的
子数组
 都 同时 包含 0 和 1 。
请你返回 稳定 二进制数组的 总 数目。

由于答案可能很大，将它对 109 + 7 取余 后返回。



示例 1：

输入：zero = 1, one = 1, limit = 2

输出：2

解释：

两个稳定的二进制数组为 [1,0] 和 [0,1] ，两个数组都有一个 0 和一个 1 ，且没有子数组长度大于 2 。

示例 2：

输入：zero = 1, one = 2, limit = 1

输出：1

解释：

唯一稳定的二进制数组是 [1,0,1] 。

二进制数组 [1,1,0] 和 [0,1,1] 都有长度为 2 且元素全都相同的子数组，所以它们不稳定。

示例 3：

输入：zero = 3, one = 3, limit = 2

输出：14

解释：

所有稳定的二进制数组包括 [0,0,1,0,1,1] ，[0,0,1,1,0,1] ，[0,1,0,0,1,1] ，[0,1,0,1,0,1] ，[0,1,0,1,1,0] ，[0,1,1,0,0,1] ，[0,1,1,0,1,0] ，[1,0,0,1,0,1] ，[1,0,0,1,1,0] ，[1,0,1,0,0,1] ，[1,0,1,0,1,0] ，[1,0,1,1,0,0] ，[1,1,0,0,1,0] 和 [1,1,0,1,0,0] 。



提示：

1 <= zero, one, limit <= 200
 */
