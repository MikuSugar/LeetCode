package JavaCode.random_records.N2201_N2400;

import utils.Parse;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/17 16:50
 */
public class N2216_minimum_deletions_to_make_array_beautiful {

    public static void main(String[] args) {
        //1
        System.out.println(new N2216_minimum_deletions_to_make_array_beautiful().minDeletion(
                Parse.parseToIntArray("[1,1,2,3,5]")
        ));
        //6
        System.out.println(new N2216_minimum_deletions_to_make_array_beautiful().minDeletion(
                Parse.parseToIntArray("[2,6,2,5,8,9,7,2,2,5,6,2,2,0,6,8,7,3,9,2,1,1,3,2,6,2,4,6,5,8,4,8,7,0,4,8,7,8," +
                        "4,1,1,4,0,1,5,7,7,5,9,7,5,5,8,6,4,3,6,5,1,6,7,6,9,9,6,8,6,0,9,5,6,7,6,9,5,5,7,3,0,0,5,5,4,8,3,9,3,4,1,7,9,3,1,8,8,9,1,6,0,0]")
        ));
    }

    public int minDeletion(int[] nums) {
        int res = 0;
        int idx = 0;
        while (idx < nums.length) {
            if (idx == nums.length - 1) {
                break;
            } else if (nums[idx] != nums[idx + 1]) {
                idx += 2;
            } else {
                int temp = 0;
                for (int i = idx + 1; i < nums.length; i++) {
                    temp = i + 1;
                    if (nums[i] == nums[idx]) {
                        res++;
                    } else {
                        break;
                    }
                }
                idx = temp;
            }
        }
        if ((nums.length - res) % 2 != 0) {
            res++;
        }
        return res;
    }
}
/*
给你一个下标从 0 开始的整数数组 nums ，如果满足下述条件，则认为数组 nums 是一个 美丽数组 ：

nums.length 为偶数
对所有满足 i % 2 == 0 的下标 i ，nums[i] != nums[i + 1] 均成立
注意，空数组同样认为是美丽数组。

你可以从 nums 中删除任意数量的元素。当你删除一个元素时，被删除元素右侧的所有元素将会向左移动一个单位以填补空缺，而左侧的元素将会保持 不变 。

返回使 nums 变为美丽数组所需删除的 最少 元素数目。

 

示例 1：

输入：nums = [1,1,2,3,5]
输出：1
解释：可以删除 nums[0] 或 nums[1] ，这样得到的 nums = [1,2,3,5] 是一个美丽数组。可以证明，要想使 nums 变为美丽数组，至少需要删除 1 个元素。
示例 2：

输入：nums = [1,1,2,2,3,3]
输出：2
解释：可以删除 nums[0] 和 nums[5] ，这样得到的 nums = [1,2,2,3] 是一个美丽数组。可以证明，要想使 nums 变为美丽数组，至少需要删除 2 个元素。
 

提示：

1 <= nums.length <= 105
0 <= nums[i] <= 105

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/minimum-deletions-to-make-array-beautiful
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
