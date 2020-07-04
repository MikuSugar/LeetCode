package JavaCode.random_records.N1401_1500;

import utils.Parse;

import java.util.Arrays;

/**
 * @Author: fangjie
 * @Date: 2020/7/4 8:43 下午
 */
public class N1498_number_of_subsequences_that_satisfy_the_given_sum_condition {
    public static void main(String[] args) {
        //[14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14]
        //22
        //272187084
        N1498_number_of_subsequences_that_satisfy_the_given_sum_condition test=new N1498_number_of_subsequences_that_satisfy_the_given_sum_condition();
        System.out.println(test.numSubseq(
                Parse.parseToIntArray("[14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14]")
                ,22)==272187084);
    }
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        long res=0;
        for (int i=0;i<nums.length;i++)
        {
            if(nums[i]*2>target)break;
            int right=search(i,nums,target-nums[i]);
            if(nums[right]+nums[i]<=target)res=(res+twoPow(right-i))%MOD;
        }
        return (int) res;
    }

    private int search(int left, int[] nums, int tar) {
        int right=nums.length-1;
        int res=left;
        while (left<=right)
        {
            int mid=(left+right)/2;
            if(nums[mid]<=tar)
            {
                res=mid;
                left=mid+1;
            }
            else right=mid-1;
        }
        return res;
    }

    private long twoPow(int n){
        if(n==0)return 1;
        long cur=2,res=1;
        while (n>0){
            if((n&1)==1)res=(res*cur)%MOD;
            cur=cur*cur%MOD;
            n>>=1;
        }
        return res;
    }

    private final static int MOD=(int) (1e9+7);
}
/*
给你一个整数数组 nums 和一个整数 target 。

请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。

由于答案可能很大，请将结果对 10^9 + 7 取余后返回。

 

示例 1：

输入：nums = [3,5,6,7], target = 9
输出：4
解释：有 4 个子序列满足该条件。
[3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
[3,5] -> (3 + 5 <= 9)
[3,5,6] -> (3 + 6 <= 9)
[3,6] -> (3 + 6 <= 9)
示例 2：

输入：nums = [3,3,6,8], target = 10
输出：6
解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
示例 3：

输入：nums = [2,3,3,4,6,7], target = 12
输出：61
解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
有效序列总数为（63 - 2 = 61）
示例 4：

输入：nums = [5,2,4,1,7,6,8], target = 16
输出：127
解释：所有非空子序列都满足条件 (2^7 - 1) = 127
 

提示：

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^6
1 <= target <= 10^6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
