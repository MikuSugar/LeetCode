package JavaCode.contest.biweekly.biweekly_n16;

import java.util.*;

/**
 * author:fangjie
 * time:2019/12/30
 */
public class N2 {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int[] sum=new int[arr.length+1];
        int left=0,right=(int) 1e5;
        for (int i=1;i<sum.length;i++)
        {
            sum[i]=sum[i-1]+arr[i-1];
        }
        while (left<right)
        {
            int mid=(left+right)/2;
            int cur=getSum(sum,mid,search(mid,arr));
            if(cur>=target)right=mid;
            else left=mid+1;
        }
        int t1=getSum(sum,left-1,search(left-1,arr));
        int t2=getSum(sum,left,search(left,arr));
        return Math.abs(t1-target)<=Math.abs(t2-target)?left-1:left;
    }
    private int getSum(int[] sum,int tar,int idx) {
        return sum[idx]+tar*(sum.length-idx-1);

    }

    private int search(int tar,int[] arr)
    {
        int res=arr.length;
        int left=0,right=arr.length-1;
        while (left<=right)
        {
            int mid=(left+right)/2;
            if(arr[mid]>tar)
            {
                res=mid;
                right=mid-1;
            }
            else left=mid+1;
        }
        return res;
    }
}
/*
给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。

如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。

请注意，答案不一定是 arr 中的数字。

 

示例 1：

输入：arr = [4,9,3], target = 10
输出：3
解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
示例 2：

输入：arr = [2,3,5], target = 10
输出：5
示例 3：

输入：arr = [60864,25176,27249,21296,20204], target = 56803
输出：11361
 

提示：

1 <= arr.length <= 10^4
1 <= arr[i], target <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
