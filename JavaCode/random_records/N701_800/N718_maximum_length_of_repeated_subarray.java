package JavaCode.random_records.N701_800;

import java.util.*;


public class N718_maximum_length_of_repeated_subarray {

    public int findLength(int[] A, int[] B) {
        int[][] dp=new int[A.length+1][B.length+1];
        int res=0;
        for (int i=1;i<=A.length;i++)
        {
            for (int j=1;j<=B.length;j++)
            {
                dp[i][j]=A[i-1]==B[j-1]?dp[i-1][j-1]+1:0;
                res=Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}
/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
