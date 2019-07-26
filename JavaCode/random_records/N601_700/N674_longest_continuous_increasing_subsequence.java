package JavaCode.random_records.N601_700;

public class N674_longest_continuous_increasing_subsequence {
    public int findLengthOfLCIS(int[] nums) {
        if(nums==null)return 0;
        if(nums.length<=1)return nums.length;
        int left=0,right=1;
        int res=0;
        while (right<nums.length)
        {
            if(nums[right]>nums[right-1])
            {
                right++;
            }
            else
            {
                res=Math.max(right-left,res);
                left=right++;

            }
        }
        res=Math.max(res,right-left);
        return res;
    }
}
/**
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * 注意：数组长度不会超过10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
