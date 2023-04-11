package JavaCode.random_records.N2401_N2600;

import utils.CheckUtil;
import utils.Parse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mikusugar
 * @version 1.0, 2023/4/6 16:06
 * @description N2537_count_the_number_of_good_subarrays
 */
public class N2537_count_the_number_of_good_subarrays {

    public static void main(String[] args) {
        final N2537_count_the_number_of_good_subarrays algo = new N2537_count_the_number_of_good_subarrays();
        CheckUtil.check(algo.countGood(Parse.parseToIntArray("[1,1,1,1,1]"), 10), 1L);
        CheckUtil.check(algo.countGood(Parse.parseToIntArray("[3,1,4,3,2,2,4]"), 2), 4L);
    }

    public long countGood(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        int cnt = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            final int rCnt = map.getOrDefault(nums[right], 0);
            cnt += rCnt;
            map.put(nums[right], rCnt + 1);
            while (cnt >= k) {
                res += nums.length - right;
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                cnt -= map.get(nums[left]);
                left++;
            }
            right++;
        }
        return res;
    }
}
/*
给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。

一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。

子数组 是原数组中一段连续 非空 的元素序列。

 

示例 1：

输入：nums = [1,1,1,1,1], k = 10
输出：1
解释：唯一的好子数组是这个数组本身。
示例 2：

输入：nums = [3,1,4,3,2,2,4], k = 2
输出：4
解释：总共有 4 个不同的好子数组：
- [3,1,4,3,2,2] 有 2 对。
- [3,1,4,3,2,2,4] 有 3 对。
- [1,4,3,2,2,4] 有 2 对。
- [4,3,2,2,4] 有 2 对。
 

提示：

1 <= nums.length <= 105
1 <= nums[i], k <= 109

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/count-the-number-of-good-subarrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
