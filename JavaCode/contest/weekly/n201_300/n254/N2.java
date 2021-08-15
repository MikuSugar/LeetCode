package JavaCode.contest.weekly.n201_300.n254;


/**
 * @author mikusugar
 */
public class N2 {

    public int[] rearrangeArray(int[] nums) {
        for (int i=1;i<nums.length-1;i++){
            if(check(i,nums))continue;
            for (int k= nums.length-1;k>=i+1;k--){
                swap(i,k,nums);
                if(check(i,nums)&&check(i-1,nums))break;
                swap(i,k,nums);
            }
            if(check(i,nums))continue;
            for (int k=0;k<=i-1;k++){
                swap(k,i,nums);
                if(check(k-1,nums)&&check(k,nums)&&check(k+1,nums)&&check(i,nums)&&check(i-1,nums))break;
                swap(k,i,nums);
            }
        }
        return nums;
    }

    private void swap(int i,int j,int[] nums){
        int tar= nums[i];
        nums[i]=nums[j];
        nums[j]=tar;
    }
    private boolean check(int i, int[] nums) {
        if(i<=0||i>= nums.length-1)return true;
        return nums[i]*1.0!=(nums[i-1]+nums[i+1])/2.0;
    }
}
/*
给你一个 下标从 0 开始 的数组 nums ，数组由若干 互不相同的 整数组成。你打算重新排列数组中的元素以满足：重排后，数组中的每个元素都 不等于 其两侧相邻元素的 平均值 。

更公式化的说法是，重新排列的数组应当满足这一属性：对于范围 1 <= i < nums.length - 1 中的每个 i ，(nums[i-1] + nums[i+1]) / 2 不等于 nums[i] 均成立 。

返回满足题意的任一重排结果。



示例 1：

输入：nums = [1,2,3,4,5]
输出：[1,2,4,5,3]
解释：
i=1, nums[i] = 2, 两相邻元素平均值为 (1+4) / 2 = 2.5
i=2, nums[i] = 4, 两相邻元素平均值为 (2+5) / 2 = 3.5
i=3, nums[i] = 5, 两相邻元素平均值为 (4+3) / 2 = 3.5
示例 2：

输入：nums = [6,2,0,9,7]
输出：[9,7,6,2,0]
解释：
i=1, nums[i] = 7, 两相邻元素平均值为 (9+6) / 2 = 7.5
i=2, nums[i] = 6, 两相邻元素平均值为 (7+2) / 2 = 4.5
i=3, nums[i] = 2, 两相邻元素平均值为 (6+0) / 2 = 3
 */

