package JavaCode.contest.weekly.n201_300.n232;

import utils.Parse;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2021/3/14 10:28 上午
 */
public class N4 {
    public static void main(String[] args) {
        System.out.println(new N4().maximumScore(
                Parse.toIntArr("[8182,1273,9847,6230,52,1467,6062,726,4852,4507,2460,2041,500,1025,5524]"),
                8
        ));
    }

    public int maximumScore(int[] nums, int k) {
        int res=-1;
        int l=k, r=k,min=nums[k];
        while (l>=0&&r<nums.length) {
            min=Math.min(nums[l],Math.min(nums[r],min));
            int s=min*(r-l+1);
            //System.out.println(l+" "+r+" "+s+" "+min);
            res=Math.max(res, s);
            if (l==0) r++;
            else if (r==nums.length-1) l--;
            else {
                if (nums[l-1]>nums[r+1]) l--;
                else r++;
            }
        }
        return res;

    }

}
/*
给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。

一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个 好 子数组的两个端点下标需要满足 i <= k <= j 。

请你返回 好 子数组的最大可能 分数 。



示例 1：

输入：nums = [1,4,3,7,4,5], k = 3
输出：15
解释：最优子数组的左右端点下标是 (1, 5) ，分数为 min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 。
示例 2：

输入：nums = [5,5,4,5,4,1,1,1], k = 0
输出：20
解释：最优子数组的左右端点下标是 (0, 4) ，分数为 min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20 。


提示：

1 <= nums.length <= 105
1 <= nums[i] <= 2 * 104
0 <= k < nums.length
 */
