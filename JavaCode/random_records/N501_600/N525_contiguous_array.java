package JavaCode.random_records.N501_600;

import java.util.HashMap;
import java.util.Map;

/**
 * author:fangjie
 * time:2019/9/19
 */
public class N525_contiguous_array {
    public int findMaxLength(int[] nums) {
        int sum=0,res=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i]==1?1:-1;
            if(map.containsKey(sum))
            {
                res=Math.max(res,i-map.get(sum));
            }
            else map.put(sum,i);
        }
        return res;
    }
}
/**
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 *
 * 输入: [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *  
 *
 * 注意: 给定的二进制数组的长度不会超过50000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
