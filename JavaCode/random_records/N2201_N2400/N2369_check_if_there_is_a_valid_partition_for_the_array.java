package JavaCode.random_records.N2201_N2400;

import utils.CheckUtil;
import utils.Parse;

/**
 * @author mikusugar
 * @version 1.0, 2024/7/22 下午4:26
 * @description N2369_check_if_there_is_a_valid_partition_for_the_array
 */
public class N2369_check_if_there_is_a_valid_partition_for_the_array {
    public static void main(String[] args) {
        CheckUtil.check(new N2369_check_if_there_is_a_valid_partition_for_the_array()
                .validPartition(Parse.toIntArr("[865579,865579,893593]")), false);
    }


    public boolean validPartition(int[] nums) {
        boolean[] used = new boolean[nums.length];
        return dfs(0, nums, used);
    }

    private boolean dfs(int index, int[] nums, boolean[] used) {
        if (index == nums.length) return true;
        if (used[index]) return false;
        used[index] = true;
        boolean result = false;
        if (helpCheck2(nums, index)) {
            result = dfs(index + 2, nums, used);
        }
        if (result) return true;
        if (helpCheck3(nums, index)) {
            return dfs(index + 3, nums, used);
        }
        return false;
    }

    private boolean helpCheck2(int[] nums, int index) {
        if (index > nums.length - 2) return false;
        return nums[index] == nums[index + 1];
    }

    private boolean helpCheck3(int[] nums, int index) {
        if (index > nums.length - 3) return false;
        return (nums[index] == nums[index + 1] && nums[index] == nums[index + 2]) ||
                (nums[index] + 1 == nums[index + 1] && nums[index] + 2 == nums[index + 2]);
    }
}
/*
给你一个下标从 0 开始的整数数组 nums ，你必须将数组划分为一个或多个 连续 子数组。

如果获得的这些子数组中每个都能满足下述条件 之一 ，则可以称其为数组的一种 有效 划分：

子数组 恰 由 2 个相等元素组成，例如，子数组 [2,2] 。
子数组 恰 由 3 个相等元素组成，例如，子数组 [4,4,4] 。
子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1 。例如，子数组 [3,4,5] ，但是子数组 [1,3,5] 不符合要求。
如果数组 至少 存在一种有效划分，返回 true ，否则，返回 false 。



示例 1：

输入：nums = [4,4,4,5,6]
输出：true
解释：数组可以划分成子数组 [4,4] 和 [4,5,6] 。
这是一种有效划分，所以返回 true 。
示例 2：

输入：nums = [1,1,1,2]
输出：false
解释：该数组不存在有效划分。


提示：

2 <= nums.length <= 10^5
1 <= nums[i] <= 10^6
 */
