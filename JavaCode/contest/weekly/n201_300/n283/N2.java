package JavaCode.contest.weekly.n201_300.n283;

import utils.Parse;

import java.util.*;

/**
 * @author mikusugar
 */
public class N2 {
    public static void main(String[] args) {
        System.out.println(new N2().minimalKSum(
                Parse.toIntArr("[21,63,1,98,10,77,58,10,21,99,40,27,5,67,90,29,56,16,34,25,26,17,8,3,4,17,14,32,12,17,37,81,18,49,59,23,63,39,64,7,18,35,89,11,42,30,6,15,81,52,24,39,48,9,19,34,24,2,28,13,53,4,22,20,42,2,5,58,36,31,60,38,33]"
                ), 20
        ));
    }

    public long minimalKSum(int[] nums, int k) {
        final HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        final ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        long res = 0;
        for (int i = 0; i < list.size(); i++) {
            if (k <= 0) break;
            if (list.get(i) != i - 1) {
                long j = 1;
                if (i > 0) j = list.get(i - 1) + 1;
                long m = Math.min(k, list.get(i) - j);
                res += (j + (j + m - 1)) * m / 2;
                k -= m;
            }
        }
        int max = list.get(list.size() - 1) + 1;
        if (k > 0) {
            res += ((long) max + (long) (max + k - 1)) * k / 2L;
        }
        return res;
    }
}
/*
给你一个整数数组 nums 和一个整数 k 。请你向 nums 中追加 k 个 未 出现在 nums 中的、互不相同 的 正 整数，并使结果数组的元素和 最小 。

返回追加到 nums 中的 k 个整数之和。



示例 1：

输入：nums = [1,4,25,10,25], k = 2
输出：5
解释：在该解法中，向数组中追加的两个互不相同且未出现的正整数是 2 和 3 。
nums 最终元素和为 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70 ，这是所有情况中的最小值。
所以追加到数组中的两个整数之和是 2 + 3 = 5 ，所以返回 5 。
示例 2：

输入：nums = [5,6], k = 6
输出：25
解释：在该解法中，向数组中追加的两个互不相同且未出现的正整数是 1 、2 、3 、4 、7 和 8 。
nums 最终元素和为 5 + 6 + 1 + 2 + 3 + 4 + 7 + 8 = 36 ，这是所有情况中的最小值。
所以追加到数组中的两个整数之和是 1 + 2 + 3 + 4 + 7 + 8 = 25 ，所以返回 25 。


提示：

1 <= nums.length <= 105
1 <= nums[i], k <= 109
 */
