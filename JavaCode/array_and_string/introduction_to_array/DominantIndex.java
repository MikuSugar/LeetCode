package JavaCode.array_and_string.introduction_to_array;

public class DominantIndex {

    public static void main(String[] args) {
        int[] t={1,0};
        System.out.println(new DominantIndex().dominantIndex(t));
    }

    public int dominantIndex(int[] nums) {
        if(nums.length<=1) return nums.length-1;

        int max_index=0;//最大索引
        int smax_index=-1;//第二大索引

        for(int i=1;i<nums.length;i++)
        {
            int sm;//第二大
            if(smax_index==-1)
            {
                sm=Integer.MIN_VALUE;
            }
            else
            {
                sm=nums[smax_index];
            }

            if(nums[i]>nums[max_index])
            {
                smax_index=max_index;
                max_index=i;
            }
            else if(nums[i]>sm)
            {
                smax_index=i;
            }

        }
        if(nums[max_index]>=2*nums[smax_index])
        {
            return max_index;
        }
        return -1;

    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/771/
 * 至少是其他数字两倍的最大数
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 *
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * 示例 1:
 *
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *
 *
 * 示例 2:
 *
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 *
 *
 * 提示:
 *
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 99].
 */
