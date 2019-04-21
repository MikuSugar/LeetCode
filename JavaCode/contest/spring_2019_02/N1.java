package JavaCode.contest.spring_2019_02;

public class N1 {
    public int missingElement(int[] nums, int k) {

        int sum=0;
        for (int i=1;i<nums.length;i++)
        {
            int temp=nums[i]-nums[i-1]-1+sum;
            if(temp>k)
            {
                return nums[i]+k-sum;
            }
            sum=temp;
        }
        return nums[nums.length-1]+k-sum;
    }
}
/**
 *  有序数组中的缺失元素  显示英文描述
 * 用户通过次数 0
 * 用户尝试次数 0
 * 通过次数 0
 * 提交次数 0
 * 题目难度 Medium
 * 给出一个有序数组 A，数组中的每个数字都是 独一无二的，找出从数组最左边开始的第 K 个缺失数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [4,7,9,10], K = 1
 * 输出：5
 * 解释：
 * 第一个缺失数字为 5 。
 * 示例 2：
 *
 * 输入：A = [4,7,9,10], K = 3
 * 输出：8
 * 解释：
 * 缺失数字有 [5,6,8,...]，因此第三个缺失数字为 8 。
 * 示例 3：
 *
 * 输入：A = [1,2,4], K = 3
 * 输出：6
 * 解释：
 * 缺失数字有 [3,5,6,7,...]，因此第三个缺失数字为 6 。
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 50000
 * 1 <= A[i] <= 1e7
 * 1 <= K <= 1e8
 */
