package JavaCode.contest.biweekly_n5;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N1 {
    public int largestUniqueNumber(int[] A) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:A)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int res=-1;
        for (Map.Entry<Integer,Integer> e:map.entrySet())
        {
            if(e.getValue()>1)continue;
            res=Math.max(res,e.getKey());
        }
        return res;
    }
}
/**
 * 给你一个整数数组 A，请找出并返回在该数组中仅出现一次的最大整数。
 *
 * 如果不存在这个只出现一次的整数，则返回 -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[5,7,3,9,4,9,8,3,1]
 * 输出：8
 * 解释：
 * 数组中最大的整数是 9，但它在数组中重复出现了。而第二大的整数是 8，它只出现了一次，所以答案是 8。
 * 示例 2：
 *
 * 输入：[9,9,8,8]
 * 输出：-1
 * 解释：
 * 数组中不存在仅出现一次的整数。
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 2000
 * 0 <= A[i] <= 1000
 */
