package JavaCode.binary_search.more_practices_ii;

import java.util.Arrays;

public class SmallestDistancePair {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0;
        int right=nums[nums.length-1]-nums[0];

        while (left<right)
        {
            int mid=left+(right-left)/2;
            int count=getconut(nums,mid);
            if(count<k)
            {
                left=mid+1;
            }
            else
            {
                right=mid;
            }
        }
        return left;
    }

    /**
     * 统计差值小于mid的个数
     * @param nums
     * @param mid
     * @return
     */
    int getconut(int[] nums,int mid)
    {
        int count=0;
        int left=0;

        for(int i=1;i<nums.length;i++)
        {
            while (nums[i]-nums[left]>mid)
            {
                left++;
            }
            count+=i-left;
        }
        return count;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/binary-search/215/more-practices-ii/860/
 * 找出第 k 小的距离对
 * 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。
 *
 * 示例 1:
 *
 * 输入：
 * nums = [1,3,1]
 * k = 1
 * 输出：0
 * 解释：
 * 所有数对如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
 * 提示:
 *
 * 2 <= len(nums) <= 10000.
 * 0 <= nums[i] < 1000000.
 * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 */
