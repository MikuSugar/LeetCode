package JavaCode.random_records.N3001_N3200;

import utils.CheckUtil;
import utils.Parse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


/**
 * @author mikusugar
 * @version 1.0, 2024/7/23 下午5:17
 * @description N3098_find_the_sum_of_subsequence_powers
 */
public class N3098_find_the_sum_of_subsequence_powers {

    public static void main(String[] args) {
        CheckUtil.check(200000000, new N3098_find_the_sum_of_subsequence_powers().
                sumOfPowers(Parse.toIntArr("[-100000000,100000000]"), 2));
        CheckUtil.check(990202285, new N3098_find_the_sum_of_subsequence_powers().
                sumOfPowers(Parse.toIntArr("[-24, -921, 119, -291, -65, " +
                        "-628, 372, 274, 962, -592, -10, 67, -977, 85, -294, 349, " +
                        "-119, -846, -959, -79, -877, 833, 857, 44, 826, -295, -855, 55" +
                        "4, -999, 759, -653, -423, -599, -928]"), 19));
        CheckUtil.check(817691423, new N3098_find_the_sum_of_subsequence_powers().sumOfPowers(
                Parse.toIntArr("[67108864" +
                        ",33554432,16777216,8388608,4194304,2097152,1048576,524288,262144,131072,65536,32768,16384," +
                        "8192,4096,2048,1024,512,256,128,64,32,16,8,4,2,1,4782969,1594323,531441,177147" +
                        ",59049,19683,6561,2187,729,243,81,27,9,3,40353607,5764801,823543,117649,16807,2401,343,49,7]")
                , 25));
    }

    private final static int MOD = 1000000007;
    private Map<Long, Integer> dp;
    private int[] nums;

    public int sumOfPowers(int[] nums, int k) {
        //todo timeout!!!
        Arrays.sort(nums);
        this.nums = nums;
        this.dp = new HashMap<>();
        return dfs(0, k, -1, Integer.MAX_VALUE);
    }

    private int dfs(int index, int k, int last, int power) {
        if (k == 0) {
            return power % MOD;
        }
        if (index >= nums.length || nums.length < k) {
            return 0;
        }
        final long key = getKey(index, k, last, power);

        Integer sum = dp.get(key);
        if (sum != null) {
            return sum;
        }
        sum = dfs(index + 1, k, last, power) % MOD;
        if (last != -1) {
            sum += (dfs(index + 1, k - 1, index, Math.min(power, nums[index] - nums[last])) % MOD);
        } else {
            sum += (dfs(index + 1, k - 1, index, power) % MOD);
        }
        sum %= MOD;
        dp.put(key, sum);
        return sum;
    }

    private static long getKey(int index, int k, int last, int power) {
        final int left = index + (k * 100) + last * 10000;
        return ((long) left << 32) | (power & 0xFFFFFFFFL);
    }
}
/*
给你一个长度为 n 的整数数组 nums 和一个 正 整数 k 。

一个
子序列
 的 能量 定义为子序列中 任意 两个元素的差值绝对值的 最小值 。

请你返回 nums 中长度 等于 k 的 所有 子序列的 能量和 。

由于答案可能会很大，将答案对 10^9 + 7 取余 后返回。



示例 1：

输入：nums = [1,2,3,4], k = 3

输出：4

解释：

nums 中总共有 4 个长度为 3 的子序列：[1,2,3] ，[1,3,4] ，[1,2,4] 和 [2,3,4] 。能量和为 |2 - 3| + |3 - 4| + |2 - 1| + |3 - 4| = 4 。

示例 2：

输入：nums = [2,2], k = 2

输出：0

解释：

nums 中唯一一个长度为 2 的子序列是 [2,2] 。能量和为 |2 - 2| = 0 。

示例 3：

输入：nums = [4,3,-1], k = 2

输出：10

解释：

nums 总共有 3 个长度为 2 的子序列：[4,3] ，[4,-1] 和 [3,-1] 。能量和为 |4 - 3| + |4 - (-1)| + |3 - (-1)| = 10 。



提示：

2 <= n == nums.length <= 50
-10^8 <= nums[i] <= 10^8
2 <= k <= n
 */
