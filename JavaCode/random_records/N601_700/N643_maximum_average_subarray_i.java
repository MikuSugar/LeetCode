package JavaCode.random_records.N601_700;

public class N643_maximum_average_subarray_i {
    public double findMaxAverage(int[] nums, int k) {
        double res=0d;
        int sum=0;
        for (int i=0;i<k;i++)
        {
            sum+=nums[i];
        }
        res=sum*1.0/k;
        int temp=sum;
        for (int i=k;i<nums.length;i++)
        {
            temp-=nums[i-k];
            temp+=nums[i];
            if(temp>sum)
            {
                res=temp*1.0/k;
                sum=temp;
            }
        }
        return res;
    }
}
/**
 * 题目描述
 * 评论 (75)
 * 题解(3)New
 * 提交记录
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例 1:
 *
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 * 注意:
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 */
