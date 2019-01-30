package JavaCode.hash_table.practical_application_hash_map;

import java.util.HashMap;
import java.util.Map;


/**
 * 一开始题意理解错误
 * 我一开始以为存在nums[i]=nums[j],其中i和j的差的绝对值最大为k，且必须存在这个最大，然而与例2冲突
 * 真正的题意是存在一对i和j，他们的差的绝对值小于k
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],i);
            }
            else
            {
                if(i-map.get(nums[i])<=k)
                    return true;
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/hash-table/205/practical-application-hash-map/817/
 * 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
