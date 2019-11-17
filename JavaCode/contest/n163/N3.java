package JavaCode.contest.n163;

import java.util.*;

/**
 * author:fangjie
 * time:2019/11/17
 */
public class N3 {
    public int maxSumDivThree(int[] nums) {
       int[][] dp=new int[nums.length+1][3];
       for (int[] d:dp) Arrays.fill(d,-Integer.MAX_VALUE>>1);
       dp[0][0]=0;
       for (int i=0;i<nums.length;i++)
       {
          for (int j=0;j<3;j++)
          {
              dp[i+1][j]=Math.max(dp[i+1][j],dp[i][j]);
              int m=(j+nums[i])%3;
              dp[i+1][m]=Math.max(dp[i+1][m],dp[i][j]+nums[i]);
          }
       }
       return dp[nums.length][0];
    }
}
/*
给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。



示例 1：

输入：nums = [3,6,5,1,8]
输出：18
解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
示例 2：

输入：nums = [4]
输出：0
解释：4 不能被 3 整除，所以无法选出数字，返回 0。
示例 3：

输入：nums = [1,2,3,4,4]
输出：12
解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。


提示：

1 <= nums.length <= 4 * 10^4
1 <= nums[i] <= 10^4
 */
