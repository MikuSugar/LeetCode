package JavaCode.contest.biweekly_n10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:fangjie
 * time:2019/10/5
 */
public class N1 {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Map<Integer,Integer> map=new HashMap<>();
        help(arr1,map);
        help(arr2,map);
        help(arr3,map);
        List<Integer> res=new ArrayList<>(arr1.length);
        for (Map.Entry<Integer,Integer> e:map.entrySet())
        {
            if(e.getValue()>=3)res.add(e.getKey());
        }
        return res;
    }

    private void help(int[] arr, Map<Integer, Integer> map) {
        for (int i:arr)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
    }
}
/**
 * 给出三个均为 绝对升序排列 的整数数组 arr1，arr2 和 arr3。
 *
 * 返回由 仅 在这三个数组中 同时出现 的整数构成一个有序数组。
 *
 *
 *
 * 示例：
 *
 * 输入: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * 输出: [1,5]
 * 解释: 只有 1 和 5 同时在这三个数组中出现.
 *
 *
 * 提示：
 *
 * 1 <= arr1.length, arr2.length, arr3.length <= 1000
 * 1 <= arr1[i], arr2[i], arr3[i] <= 2000
 */
