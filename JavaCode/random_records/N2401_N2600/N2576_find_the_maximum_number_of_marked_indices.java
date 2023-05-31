package JavaCode.random_records.N2401_N2600;

import utils.Parse;

import java.util.Arrays;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/23 17:00
 * @description N2576_find_the_maximum_number_of_marked_indices
 */
public class N2576_find_the_maximum_number_of_marked_indices {
    public static void main(String[] args) {
        System.out.println(new N2576_find_the_maximum_number_of_marked_indices().maxNumOfMarkedIndices(
                Parse.toIntArr("[1,78,27,48,14,8" +
                        "6,79,68,77,20,57,21,18,67,5,51,70,85,47,56,22,79,41,8,39,81,59,74,14,45," +
                        "49,15,10,28,16,77,22,65,8,36,79,94,44,80,72,8,96,78,39,92,69,55,9,44,26,76,40,77,16,69,40,64,12,48,66,7,59,10]")
        ));
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int i = 0;
        int j = nums.length / 2;
        while (i < nums.length / 2 && j < nums.length) {
            while (j < nums.length) {
                if (nums[i] * 2 <= nums[j]) {
                    res += 2;
                    j++;
                    break;
                }
                j++;
            }
            i++;
        }
        return res;
    }
}
/*
给你一个下标从 0 开始的整数数组 nums 。

一开始，所有下标都没有被标记。你可以执行以下操作任意次：

选择两个 互不相同且未标记 的下标 i 和 j ，满足 2 * nums[i] <= nums[j] ，标记下标 i 和 j 。
请你执行上述操作任意次，返回 nums 中最多可以标记的下标数目。

 

示例 1：

输入：nums = [3,5,2,4]
输出：2
解释：第一次操作中，选择 i = 2 和 j = 1 ，操作可以执行的原因是 2 * nums[2] <= nums[1] ，标记下标 2 和 1 。
没有其他更多可执行的操作，所以答案为 2 。
示例 2：

输入：nums = [9,2,5,4]
输出：4
解释：第一次操作中，选择 i = 3 和 j = 0 ，操作可以执行的原因是 2 * nums[3] <= nums[0] ，标记下标 3 和 0 。
第二次操作中，选择 i = 1 和 j = 2 ，操作可以执行的原因是 2 * nums[1] <= nums[2] ，标记下标 1 和 2 。
没有其他更多可执行的操作，所以答案为 4 。
示例 3：

输入：nums = [7,6,8]
输出：0
解释：没有任何可以执行的操作，所以答案为 0 。
 

提示：

1 <= nums.length <= 105
1 <= nums[i] <= 109

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/find-the-maximum-number-of-marked-indices
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
