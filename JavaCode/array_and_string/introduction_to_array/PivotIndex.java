package JavaCode.array_and_string.introduction_to_array;

public class PivotIndex {

    public static void main(String[] args) {
        int[] t={-1,-1,0,1,1,0};
        System.out.println(new PivotIndex().pivotIndex(t));
    }

    public int pivotIndex(int[] nums) {

        if(nums.length<=1) return nums.length-1;
        int head=0;
        int tail=nums.length;

        int[] sum=new int[nums.length+1];//后缀和
        sum[nums.length-1]=nums[nums.length-1];

        for(int i=nums.length-2;i>=0;i--)
        {
            sum[i]=sum[i+1]+nums[i];
        }

        int s=0;
        for(int i=0;i<nums.length;i++)
        {
            if(s==sum[i+1])return i;
            s+=nums[i];
        }
        return -1;

    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/770/
 * 寻找数组的中心索引
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 *
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * 示例 1:
 *
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: 3
 * 解释:
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2:
 *
 * 输入:
 * nums = [1, 2, 3]
 * 输出: -1
 * 解释:
 * 数组中不存在满足此条件的中心索引。
 * 说明:
 *
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 */
