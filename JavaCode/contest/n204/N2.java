package JavaCode.contest.n204;

import java.util.HashMap;
import java.util.Map;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/8/30 10:23 上午
 */
public class N2 {
    public int getMaxLen(int[] nums) {
        int[] f_sum=new int[nums.length+1];
        for (int i=0;i<nums.length;i++)
        {
            f_sum[i+1]=f_sum[i];
            if(nums[i]<0)f_sum[i+1]++;
        }
        int left=0;
        int res=0;
        for (int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                if(i>left)
                {
                    for (int len=i-left;len>0;len--)
                    {
                        if(len<res)break;
                        for (int k=left;k+len<=i;k++)
                        {
                            res=Math.max(res,slove(k,k+len,f_sum));
                        }
                    }
                }
                left=i+1;
            }
        }
        for (int len=nums.length-left;len>0;len--)
        {
            if(len<res)break;
            for (int k=left;k+len<=nums.length;k++)
            {
                res=Math.max(res,slove(k,k+len,f_sum));
            }
        }
        return res;
    }

    private int slove(int l, int r, int[] f_sum) {
        if(l>=r)return 0;
        if((f_sum[r]-f_sum[l])%2==0)return r-l;
        return 0;
    }
}
/*
给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。

一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。

请你返回乘积为正数的最长子数组长度。



示例  1：

输入：nums = [1,-2,-3,4]
输出：4
解释：数组本身乘积就是正数，值为 24 。
示例 2：

输入：nums = [0,1,-2,-3,-4]
输出：3
解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
示例 3：

输入：nums = [-1,-2,-3,0,1]
输出：2
解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
示例 4：

输入：nums = [-1,2]
输出：1
示例 5：

输入：nums = [1,2,3,5,-6,4,0,10]
输出：4


提示：

1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
 */
