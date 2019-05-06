package JavaCode.random_records.N1_100;

public class N31_next_permutation {
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length<2)return;
        int pre=-1;
        for (int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                pre=i;
                break;
            }
        }
        if(pre!=-1)
        {
            int sec=-1;
            for (int i=nums.length-1;i>pre;i--)
            {
                if(nums[i]>nums[pre])
                {
                    sec=i;
                    break;
                }
            }
            swap(pre,sec,nums);
        }
        reverse(pre+1,nums.length-1,nums);
    }
    private void  swap(int i,int j,int[] nums)
    {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    private void reverse(int i,int j,int[] nums)
    {
        while (i<j)
        {
            swap(i++,j--,nums);
        }
    }
}
/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
