package JavaCode.contest.n148;

import java.util.Map;

public class N1 {
    public static void main(String[] args) {
        System.out.println(new N1().movesToMakeZigzag(new int[]{7,4,8,9,7,7,5}));
    }
    public int movesToMakeZigzag(int[] nums) {
        int res=0;
        int[] a=new int[nums.length];
        System.arraycopy(nums,0,a,0,nums.length);
        for (int i=1;i<nums.length;i+=2)
        {
            if(a[i-1]>=a[i])
            {
                res += a[i - 1] - a[i] + 1;
            }
            if(i+1<nums.length)
            {
                if(a[i+1]>=a[i])
                {
                    res+=a[i+1]-a[i]+1;
                    a[i+1]=a[i]-1;
                }
            }
        }
        int res2=0;
        for (int i=0;i<nums.length;i+=2)
        {
            if(i-1>=0)
            {
                if(nums[i-1]>=nums[i])
                {
                    res2+=nums[i-1]-nums[i]+1;
                    nums[i-1]=nums[i]-1;
                }
            }
            if(i+1<nums.length)
            {
                if(nums[i+1]>=nums[i])
                {
                    res2+=nums[i+1]-nums[i]+1;
                    nums[i+1]=nums[i]-1;
                }
            }
        }
        System.out.println(res2);
        return Math.min(res,res2);
    }
}
/**
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 *
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 *
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都小于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：我们可以把 2 递减到 0，或把 3 递减到 1。
 * 示例 2：
 *
 * 输入：nums = [9,6,1,6,2]
 * 输出：4
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 */
