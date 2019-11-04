package JavaCode.contest.biweekly_n12;

import java.util.Arrays;

/**
 * author:fangjie
 * time:2019/11/4
 */
public class N4 {
    public int minimumMoves(int[] arr) {
        int[][] dp=new int[arr.length][arr.length];
        for (int i=0;i<arr.length;i++) Arrays.fill(dp[i],-1);
        return slove(0,arr.length-1,dp,arr);
    }

    private int slove(int left, int right, int[][] dp, int[] arr) {
        if(left>=right)return 1;
        if(dp[left][right]!=-1)return dp[left][right];
        int mid=Integer.MAX_VALUE>>1;
        if(arr[left]==arr[right])mid=slove(left+1,right-1,dp,arr);
        int res=Math.min(mid,Math.min(slove(left+1,right,dp,arr)+1,slove(left,right-1,dp,arr)+1));
        for (int i=left;i<right;i++)
        {
            res=Math.min(res,slove(left,i,dp,arr)+slove(i+1,right,dp,arr));
        }
        return dp[left][right]=res;
    }
}
/*
给你一个整数数组 arr，每一次操作你都可以选择并删除它的一个 回文 子数组 arr[i], arr[i+1], ..., arr[j]（ i <= j）。

注意，每当你删除掉一个子数组，右侧元素都会自行向前移动填补空位。

请你计算并返回从数组中删除所有数字所需的最少操作次数。



示例 1：

输入：arr = [1,2]
输出：2
示例 2：

输入：arr = [1,3,4,1,5]
输出：3
解释：先删除 [4]，然后删除 [1,3,1]，最后再删除 [5]。


提示：

1 <= arr.length <= 100
1 <= arr[i] <= 20
 */
