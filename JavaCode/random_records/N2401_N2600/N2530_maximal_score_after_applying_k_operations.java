package JavaCode.random_records.N2401_N2600;

import utils.CheckUtil;
import utils.Parse;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/31 15:18
 * @description N2530_maximal_score_after_applying_k_operations
 */
public class N2530_maximal_score_after_applying_k_operations {
    public static void main(String[] args) {
        final N2530_maximal_score_after_applying_k_operations algo = new N2530_maximal_score_after_applying_k_operations();
        CheckUtil.check(algo.maxKelements(Parse.parseToIntArray("[10,10,10,10,10]"), 5), 50L);
        CheckUtil.check(algo.maxKelements(Parse.parseToIntArray("[1,10,3,3,3]"), 3), 17L);
    }

    public long maxKelements(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) pq.add(num);
        long res = 0;
        while (k-- > 0 && !pq.isEmpty()) {
            final int max = pq.poll();
            res += max;
            final int newNum = (int) Math.ceil(max * 1.0 / 3);
            pq.add(newNum);
        }
        return res;
    }
}
/*
给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你的 起始分数 为 0 。

在一步 操作 中：

选出一个满足 0 <= i < nums.length 的下标 i ，
将你的 分数 增加 nums[i] ，并且
将 nums[i] 替换为 ceil(nums[i] / 3) 。
返回在 恰好 执行 k 次操作后，你可能获得的最大分数。

向上取整函数 ceil(val) 的结果是大于或等于 val 的最小整数。

 

示例 1：

输入：nums = [10,10,10,10,10], k = 5
输出：50
解释：对数组中每个元素执行一次操作。最后分数是 10 + 10 + 10 + 10 + 10 = 50 。
示例 2：

输入：nums = [1,10,3,3,3], k = 3
输出：17
解释：可以执行下述操作：
第 1 步操作：选中 i = 1 ，nums 变为 [1,4,3,3,3] 。分数增加 10 。
第 2 步操作：选中 i = 1 ，nums 变为 [1,2,3,3,3] 。分数增加 4 。
第 3 步操作：选中 i = 2 ，nums 变为 [1,1,1,3,3] 。分数增加 3 。
最后分数是 10 + 4 + 3 = 17 。
 

提示：

1 <= nums.length, k <= 105
1 <= nums[i] <= 109


来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/maximal-score-after-applying-k-operations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
