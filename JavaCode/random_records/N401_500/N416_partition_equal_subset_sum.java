package JavaCode.random_records.N401_500;



public class N416_partition_equal_subset_sum {

    public boolean canPartition(int[] nums) {
        if(nums==null||nums.length<2)return false;
        int sum=0;
        for (int i:nums)
        {
            sum+=i;
        }
        if((sum&1)!=0)return false;
        int target=sum/2;

        boolean[][] dp=new boolean[nums.length][target+1];
        if(nums[0]<=target)dp[0][nums[0]]=true;
        for (int i=1;i<nums.length;i++)
        {
            for (int j=0;j<=target;j++)
            {
                dp[i][j]=dp[i-1][j];
                if(j>=nums[i])
                {
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][target];
    }
}
/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
