package JavaCode.random_records.N2201_N2400;

import utils.Parse;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/17 16:35
 */
public class N2348_number_of_zero_filled_subarrays {

    public static void main(String[] args) {
        System.out.println(new N2348_number_of_zero_filled_subarrays().zeroFilledSubarray(
                Parse.toIntArr("[0,0,0,2,0,0]")
        ));
    }
    public long zeroFilledSubarray(int[] nums) {
        long res = 0L;
        int idx = 0;
        while (idx < nums.length) {
            if (nums[idx] == 0) {
                int lastIdx = idx;
                for (int i = idx; i < nums.length; i++) {
                    if (nums[i] != 0) {
                        break;
                    } else {
                        lastIdx = i;
                    }
                }
                res += help(idx, lastIdx);
                idx = lastIdx + 1;
            } else {
                idx++;
            }
        }
        return res;
    }

    private long help(int idx, int lastIdx) {
        long len = lastIdx - idx + 1;
        return (len + 1) * len / 2;
    }
}
/*
给你一个整数数组 nums ，返回全部为 0 的 子数组 数目。

子数组 是一个数组中一段连续非空元素组成的序列。

 

示例 1：

输入：nums = [1,3,0,0,2,0,0,4]
输出：6
解释：
子数组 [0] 出现了 4 次。
子数组 [0,0] 出现了 2 次。
不存在长度大于 2 的全 0 子数组，所以我们返回 6 。
示例 2：

输入：nums = [0,0,0,2,0,0]
输出：9
解释：
子数组 [0] 出现了 5 次。
子数组 [0,0] 出现了 3 次。
子数组 [0,0,0] 出现了 1 次。
不存在长度大于 3 的全 0 子数组，所以我们返回 9 。
示例 3：

输入：nums = [2,10,2019]
输出：0
解释：没有全 0 子数组，所以我们返回 0 。
 

提示：

1 <= nums.length <= 105
-109 <= nums[i] <= 109

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/number-of-zero-filled-subarrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
