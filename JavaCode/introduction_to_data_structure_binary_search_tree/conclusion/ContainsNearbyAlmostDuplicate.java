package JavaCode.introduction_to_data_structure_binary_search_tree.conclusion;

import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2 || k < 1 || t < 0) return false;

        SortedSet<Long> set = new TreeSet();

        for (int i = 0; i < nums.length; i++) {
            SortedSet<Long> set1 = set.subSet((long) nums[i] - t, (long) nums[i] + t + 1);
            if (!set1.isEmpty()) {
                return true;
            }
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
            set.add((long) nums[i]);
        }
        return false;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/66/conclusion/186/
 * 存在重复元素 III
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 */
