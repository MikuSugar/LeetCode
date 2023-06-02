package JavaCode.random_records.N1901_N2100;

import java.util.*;

/**
 * @author mikusugar
 * @version 1.0, 2023/6/2 14:37
 * @description N2099_find_subsequence_of_length_k_with_the_largest_sum
 */
public class N2099_find_subsequence_of_length_k_with_the_largest_sum {
    public int[] maxSubsequence(int[] nums, int k) {
        final List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new int[]{nums[i], i});
        }
        list.sort((o1, o2) -> Integer.compare(o2[0], o1[0]));

        final List<int[]> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(list.get(i));
        }
        res.sort(Comparator.comparingInt(o -> o[1]));

        final int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = res.get(i)[0];
        }
        return ans;
    }
}
/*
给你一个整数数组 nums 和一个整数 k 。你需要找到 nums 中长度为 k 的 子序列 ，且这个子序列的 和最大 。

请你返回 任意 一个长度为 k 的整数子序列。

子序列 定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。

 

示例 1：

输入：nums = [2,1,3,3], k = 2
输出：[3,3]
解释：
子序列有最大和：3 + 3 = 6 。
示例 2：

输入：nums = [-1,-2,3,4], k = 3
输出：[-1,3,4]
解释：
子序列有最大和：-1 + 3 + 4 = 6 。
示例 3：

输入：nums = [3,4,3,3], k = 2
输出：[3,4]
解释：
子序列有最大和：3 + 4 = 7 。
另一个可行的子序列为 [4, 3] 。
 

提示：

1 <= nums.length <= 1000
-105 <= nums[i] <= 105
1 <= k <= nums.length

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/find-subsequence-of-length-k-with-the-largest-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
