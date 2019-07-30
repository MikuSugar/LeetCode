package JavaCode.random_records.N301_400;

import java.util.TreeMap;

public class N327_count_of_range_sum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum=new long[nums.length+1];
        for (int i=0;i<nums.length;i++)
        {
            sum[i+1]=sum[i]+nums[i];
        }
        TreeMap<Long,Integer> map=new TreeMap<>();
        int res=0;
        map.put(0l,1);
        for (int i=1;i<sum.length;i++)
        {
            for (int cnt:map.subMap(sum[i]-upper,true,sum[i]-lower,true).values())
            {
                res+=cnt;
            }
            map.put(sum[i],map.getOrDefault(sum[i],0)+1);
        }
        return res;
    }
}
/**
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 *
 * 说明:
 * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
 *
 * 示例:
 *
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-range-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
