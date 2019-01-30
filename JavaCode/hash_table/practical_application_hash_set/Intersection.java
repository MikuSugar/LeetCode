package JavaCode.hash_table.practical_application_hash_set;

import java.util.*;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        for (int i:nums1)
        {
            set.add(i);
        }

        List<Integer> result=new ArrayList<>();
        for(int i:nums2)
        {
            if(set.contains(i))
            {
                result.add(i);
                set.remove(i);
            }
        }

        int[] ans=new int[result.size()];
        for(int i=0;i<result.size();i++)
        {
            ans[i]=result.get(i);
        }
        return ans;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/hash-table/204/practical-application-hash-set/807/
 * 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
