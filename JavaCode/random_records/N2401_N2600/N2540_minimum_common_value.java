package JavaCode.random_records.N2401_N2600;

import java.sql.Array;
import java.util.Arrays;

/**
 * @author mikusugar
 * @version 1.0, 2023/4/6 17:12
 * @description N2540_minimum_common_value
 */
public class N2540_minimum_common_value {
    public int getCommon(int[] nums1, int[] nums2) {
        if (nums1[0] > nums2[nums2.length - 1] || nums2[0] > nums1[nums1.length - 1]) {
            return -1;
        }
        int idx1 = 0, idx2 = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            int num1 = nums1[idx1];
            int num2 = nums2[idx2];
            if (num1 == num2) {
                return num1;
            } else if (num1 > num2) {
                idx2++;
            } else {
                idx1++;
            }
        }
        return -1;
    }
}
/*
给你两个整数数组 nums1 和 nums2 ，它们已经按非降序排序，请你返回两个数组的 最小公共整数 。如果两个数组 nums1 和 nums2 没有公共整数，请你返回 -1 。

如果一个整数在两个数组中都 至少出现一次 ，那么这个整数是数组 nums1 和 nums2 公共 的。

 

示例 1：

输入：nums1 = [1,2,3], nums2 = [2,4]
输出：2
解释：两个数组的最小公共元素是 2 ，所以我们返回 2 。
示例 2：

输入：nums1 = [1,2,3,6], nums2 = [2,3,4,5]
输出：2
解释：两个数组中的公共元素是 2 和 3 ，2 是较小值，所以返回 2 。
 

提示：

1 <= nums1.length, nums2.length <= 105
1 <= nums1[i], nums2[j] <= 109
nums1 和 nums2 都是 非降序 的。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/minimum-common-value
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
