package JavaCode.random_records.N601_700;

import java.util.Arrays;

public class N673_number_of_longest_increasing_subsequence {
    public int findNumberOfLIS(int[] nums) {
        if(nums==null)return 0;
        if(nums.length<=1)return nums.length;
        int[] len=new int[nums.length];
        int[] count=new int[nums.length];
        Arrays.fill(count,1);
        for (int i=0;i<nums.length;i++)
        {
            for (int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    if(len[j]>=len[i])
                    {
                        len[i]=len[j]+1;
                        count[i]=count[j];
                    }
                    else if(len[j]+1==len[i])
                    {
                        count[i]+=count[j];
                    }
                }
            }
        }
        int max_len=0,res=0;
        for (int i:len)
        {
            max_len=Math.max(i,max_len);
        }
        for (int i=0;i<len.length;i++)
        {
            if(len[i]==max_len)
            {
                res+=count[i];
            }
        }
        return res;
    }
}
/**
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
