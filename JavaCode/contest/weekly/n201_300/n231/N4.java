package JavaCode.contest.weekly.n201_300.n231;


import utils.Parse;

import java.util.Arrays;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2021/3/7 10:27 上午
 */
public class N4 {
    //[26,19,19,28,13,14,6,25,28,19,0,15,25,11]
    //3
    //11
    public static void main(String[] args) {
        System.out.println(new N4().minChanges(
                Parse.parseToIntArray("[26,19,19,28,13,14,6,25,28,19,0,15,25,11]"),
                3));
    }
    private final int MAX=Integer.MAX_VALUE>>1;
    public int minChanges(int[] nums, int k) {
        int[][] dp=new int[k+1][1<<10];
        for (int[] arr:dp) Arrays.fill(arr,MAX);
        dp[0][0]=0;
        int sum=0,min=MAX;
        for (int i=1;i<=k;i++) {
            int l=(nums.length+k-1)/k;
            if(nums.length%k!=0&&nums.length%k<i)l--;
            int[] s=new int[1<<10];
            for (int j=0;j<l;j++)s[nums[j*k+i-1]]++;
            int max=0;
            for (int j=0;j<1<<10;j++) max=Math.max(max,s[j]);
            min=Math.min(min,max);
            sum+=l-max;
            for (int j=0;j<l;j++)
            {
                int x=nums[j*k+i-1],cost=l-s[x];
                for (int u=0;u<1<<10;u++)
                {
                    dp[i][u]=Math.min(dp[i][u],dp[i-1][x^u]+cost);
                }
            }
        }
        return Math.min(sum+min,dp[k][0]);
    }
}
/*
给你一个整数数组 nums​​​ 和一个整数 k​​​​​ 。区间 [left, right]（left <= right）的 异或结果 是对下标位于 left 和 right（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR nums[right] 。

返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。



示例 1：

输入：nums = [1,2,0,3,0], k = 1
输出：3
解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
示例 2：

输入：nums = [3,4,5,2,1,7,3,4,7], k = 3
输出：3
解释：将数组 [3,4,5,2,1,7,3,4,7] 修改为 [3,4,7,3,4,7,3,4,7]
示例 3：

输入：nums = [1,2,4,1,2,5,1,2,6], k = 3
输出：3
解释：将数组[1,2,4,1,2,5,1,2,6] 修改为 [1,2,3,1,2,3,1,2,3]


提示：

1 <= k <= nums.length <= 2000
​​​​​​0 <= nums[i] < 210
 */
