package JavaCode.random_records.N601_700;

import java.util.HashMap;
import java.util.Map;

public class N697_degree_of_an_array {

    public int findShortestSubArray(int[] nums) {
        Map<Integer,int[]> map=new HashMap<>();//value [0]次数 [1]起点 [2]长度
        for (int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                int[] pair=map.get(nums[i]);
                pair[0]++;
                pair[2]=i-pair[1]+1;
            }
            else map.put(nums[i],new int[]{1,i,1});
        }
        int res=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int[] pair:map.values())
        {
            if(pair[0]==max)
            {
                res=Math.min(res,pair[2]);
            }
            else if(pair[0]>max)
            {
                max=pair[0];
                res=pair[2];
            }
        }
        return res;
    }
}
/**
 * https://leetcode-cn.com/problems/degree-of-an-array/
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1:
 *
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2:
 *
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 注意:
 *
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 */
