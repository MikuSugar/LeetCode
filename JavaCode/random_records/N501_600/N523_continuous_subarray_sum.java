package JavaCode.random_records.N501_600;


import java.util.HashMap;
import java.util.Map;

public class N523_continuous_subarray_sum {
    public boolean checkSubarraySum(int[] nums, int k) {
        k=Math.abs(k);
        if(k==0)
        {
            int cnt=0;
            for (int i:nums)
            {
                if(i==0)cnt++;
                else cnt=0;
                if(cnt>1)return true;
            }
            return false;
        }
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        for (int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            sum%=k;
            int idx=map.getOrDefault(sum,i);
            if(i-idx>1)return true;
            if(idx==i)map.put(sum,idx);
        }
        return false;
    }
}
/**
 * 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 *
 * 示例 1:
 *
 * 输入: [23,2,4,6,7], k = 6
 * 输出: True
 * 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
 * 示例 2:
 *
 * 输入: [23,2,6,4,7], k = 6
 * 输出: True
 * 解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 * 说明:
 *
 * 数组的长度不会超过10,000。
 * 你可以认为所有数字总和在 32 位有符号整数范围内。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
