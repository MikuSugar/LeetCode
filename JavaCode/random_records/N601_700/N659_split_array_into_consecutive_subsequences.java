package JavaCode.random_records.N601_700;

import java.util.HashMap;
import java.util.Map;

public class N659_split_array_into_consecutive_subsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> book=new HashMap<>();
        for (int i:nums)
        {
            book.put(i,book.getOrDefault(i,0)+1);
        }

        Map<Integer,Integer> map=new HashMap<>();
        for (int i:nums)
        {
            if(book.get(i)==0)continue;
            if(map.getOrDefault(i,0)>0)
            {
                map.put(i,map.get(i)-1);
                map.put(i+1,map.getOrDefault(i+1,0)+1);
            }
            else if(book.getOrDefault(i+1,0)>0&&book.getOrDefault(i+2,0)>0&&book.getOrDefault(i+2,0)>0)
            {
                book.put(i+1,book.get(i+1)-1);
                book.put(i+2,book.get(i+2)-1);
                map.put(i+3,map.getOrDefault(i+3,0)+1);
            }
            else return false;
            book.put(i,book.get(i)-1);
        }
        return true;
    }
}
/**
 * https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/
 * 输入一个按升序排序的整数数组（可能包含重复数字），你需要将它们分割成几个子序列，其中每个子序列至少包含三个连续整数。返回你是否能做出这样的分割？
 * 示例 1：
 *
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *
 *
 * 示例 2：
 *
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *
 *
 * 示例 3：
 *
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 */
