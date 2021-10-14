package JavaCode.contest.weekly.n201_300.n262;

import utils.Parse;

import java.sql.Array;
import java.util.Arrays;

/**
 * @author mikusugar
 */
public class N4 {

    public static void main(String[] args) {
        System.out.println(new N4().minimumDifference(
                Parse.parseToIntArray("[-48132,-98242,-75860,36593,92379,-2438,44463,51332,-23848,42999,27281,46094,-36780,36131]"))
        );
    }

    public int minimumDifference(int[] nums) {

        int min = Integer.MAX_VALUE;
        for (int i : nums) min = Math.min(min, i);
        if (min < 0) {
            for (int i = 0; i < nums.length; i++) nums[i] -= (min - 1);
        }

        int sum = 0;
        for (int i : nums) sum += i;

        int len = nums.length / 2;

        boolean[][] flag = new boolean[len + 1][sum / 2 + 1];
        flag[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = Math.min(i, len); j > 0; j--) {
                for (int k = 0; k <= sum / 2; k++) {
                    if (k >= nums[i - 1] && flag[j - 1][k - nums[i - 1]]) {
                        flag[j][k] = true;
                    }
                }
            }
        }
        // 找出最接近sum/2的k值
        for (int k = sum / 2; k > 0; k--) {
            if (flag[len][k]) {
                return Math.abs(2 * k - sum);
            }
        }
        return -1;

    }
}
/*
给你一个长度为 2 * n 的整数数组。你需要将 nums 分成 两个 长度为 n 的数组，分别求出两个数组的和，并 最小化 两个数组和之 差的绝对值 。nums 中每个元素都需要放入两个数组之一。

请你返回 最小 的数组和之差。



示例 1：

example-1

输入：nums = [3,9,7,3]
输出：2
解释：最优分组方案是分成 [3,9] 和 [7,3] 。
数组和之差的绝对值为 abs((3 + 9) - (7 + 3)) = 2 。
示例 2：

输入：nums = [-36,36]
输出：72
解释：最优分组方案是分成 [-36] 和 [36] 。
数组和之差的绝对值为 abs((-36) - (36)) = 72 。
示例 3：

example-3

输入：nums = [2,-1,0,4,-2,-9]
输出：0
解释：最优分组方案是分成 [2,4,-9] 和 [-1,0,-2] 。
数组和之差的绝对值为 abs((2 + 4 + -9) - (-1 + 0 + -2)) = 0 。


提示：

1 <= n <= 15
nums.length == 2 * n
-107 <= nums[i] <= 107
 */
