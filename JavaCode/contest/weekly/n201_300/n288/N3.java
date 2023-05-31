package JavaCode.contest.weekly.n201_300.n288;

import utils.Parse;

import java.util.*;

/**
 * @author mikusugar
 */
public class N3 {


    public static void main(String[] args) {
        System.out.println(new N3().maximumProduct(
                Parse.toIntArr("[24,5,64,53,26,38]")
                , 54
        ));
        System.out.println(fastPow(8, 2));
    }

    private final static int MOD = (int) (1e9 + 7);

    public int maximumProduct(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(new int[]{e.getKey(), e.getValue()});
        }

        while (k > 0) {
            if (pq.size() == 1) {
                final int[] poll = pq.poll();
                final int add = k / poll[1];
                poll[0] += add;
                k -= poll[1] * add;
                if (k == 0) pq.add(poll);
                else {
                    poll[1] -= k;
                    pq.add(poll);
                    final int[] ints = {poll[0] + 1, k};
                    pq.add(ints);
                    k = 0;
                }
            } else {
                int[] min = pq.poll();
                int[] max = pq.poll();

                int add = Math.min(k / min[1], max[0] - min[0]);
                min[0] += add;
                k -= add * min[1];
                if (min[0] == max[0]) {
                    pq.add(new int[]{min[0], min[1] + max[1]});
                } else {
                    pq.add(max);
                    if (k == 0) pq.add(min);
                    else {
                        min[1] -= k;
                        pq.add(min);
                        pq.add(new int[]{min[0] + 1, k});
                        k = 0;
                    }
                }
            }
        }


        long res = 1L;
        while (!pq.isEmpty()) {
            final int[] cur = pq.poll();
            res = res % MOD * fastPow(cur[0], cur[1]) % MOD;
        }
        return (int) res;

    }

    private static long fastPow(long num, long k) {
        if (k == 0) return 1;
        if (k == 1) return num;
        return fastPow(num, k / 2) % MOD * fastPow(num, k - k / 2) % MOD;
    }
}
/*
给你一个非负整数数组 nums 和一个整数 k 。每次操作，你可以选择 nums 中 任一 元素并将它 增加 1 。

请你返回 至多 k 次操作后，能得到的 nums的 最大乘积 。由于答案可能很大，请你将答案对 109 + 7 取余后返回。



示例 1：

输入：nums = [0,4], k = 5
输出：20
解释：将第一个数增加 5 次。
得到 nums = [5, 4] ，乘积为 5 * 4 = 20 。
可以证明 20 是能得到的最大乘积，所以我们返回 20 。
存在其他增加 nums 的方法，也能得到最大乘积。
示例 2：

输入：nums = [6,3,3,2], k = 2
输出：216
解释：将第二个数增加 1 次，将第四个数增加 1 次。
得到 nums = [6, 4, 3, 3] ，乘积为 6 * 4 * 3 * 3 = 216 。
可以证明 216 是能得到的最大乘积，所以我们返回 216 。
存在其他增加 nums 的方法，也能得到最大乘积。


提示：

1 <= nums.length, k <= 105
0 <= nums[i] <= 106
 */
