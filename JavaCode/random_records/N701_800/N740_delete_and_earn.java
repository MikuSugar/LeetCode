package JavaCode.random_records.N701_800;

import java.util.Map;

public class N740_delete_and_earn
{
    final static int LEN=10001;
    public int deleteAndEarn(int[] nums)
    {
        int[] dp=new int[LEN];
        int[] sum=new int[LEN];
        int max=0;
        for (int i:nums)
        {
            max=Math.max(max,i);
            sum[i]+=i;
        }
        dp[0]=0;
        dp[1]=sum[1];
        for (int i=2;i<=max;i++)
        {
            dp[i]=Math.max(dp[i-1],dp[i-2]+sum[i]);
        }
        return dp[max];
    }
}
/**
 * 给定一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 * 示例 1:
 *
 * 输入: nums = [3, 4, 2]
 * 输出: 6
 * 解释:
 * 删除 4 来获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 来获得 2 个点数。总共获得 6 个点数。
 * 示例 2:
 *
 * 输入: nums = [2, 2, 3, 3, 3, 4]
 * 输出: 9
 * 解释:
 * 删除 3 来获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * 注意:
 *
 * nums的长度最大为20000。
 * 每个整数nums[i]的大小都在[1, 10000]范围内。
 */
