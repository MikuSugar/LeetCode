package JavaCode.binary_search.more_practices_ii;

public class SplitArray {
    public int splitArray(int[] nums, int m) {
        int left=0;
        int right=0;

        for(int i:nums)
        {
            right+=i;
            left=Math.max(left,i);
        }

        while (left<right)
        {
            int mid=left+(right-left)/2;

            if(canSplit(nums,m,mid))
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }

        }
        return left;
    }

    /**
     * 判断能否划分
     * @param nums
     * @param m 划分的最大段数
     * @param sum 每段的最大值
     * @return
     */
    boolean canSplit(int[] nums,int m,int sum)
    {
        int cnt=1;
        int tempSum=0;

        for (int i=0;i<nums.length;i++)
        {
            tempSum+=nums[i];

            if(tempSum>sum)
            {
                tempSum=nums[i];
                cnt++;
                if(cnt>m)
                    return false;
            }
        }
        return true;
    }


}
/**
 * https://leetcode-cn.com/explore/learn/card/binary-search/215/more-practices-ii/861/
 * 分割数组的最大值
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 注意:
 * 数组长度 n 满足以下条件:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 *
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * 输出:
 * 18
 *
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 */
