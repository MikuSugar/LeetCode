package JavaCode.random_records.N601_700;

import java.util.*;

/**
 * author:fangjie
 * time:2019/10/31
 */
public class N632_smallest_range_covering_elements_from_k_lists {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> list=new ArrayList<>();
        for (int i=0;i<nums.size();i++)
        {
            for (int num:nums.get(i))
            {
                list.add(new int[]{num,i});
            }
        }

        list.sort(Comparator.comparingInt(o->o[0]));

        int[] res={-Integer.MAX_VALUE>>1,Integer.MAX_VALUE>>1};
        int[] book=new int[nums.size()];
        int cnt=0,left=0,right=0;
        while (right<list.size())
        {
            while (right<list.size()&&cnt<nums.size())
            {
                int[] cur=list.get(right++);
                book[cur[1]]++;
                if(book[cur[1]]==1)cnt++;
            }
            int[] r=list.get(right-1);
            while (left<right&&cnt==nums.size())
            {
                int[] l=list.get(left++);
                if(r[0]-l[0]<res[1]-res[0])
                {
                    res[0]=l[0];
                    res[1]=r[0];
                }
                book[l[1]]--;
                if(book[l[1]]==0)cnt--;
            }
        }
        return res;
    }
}
/*
你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。

我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。

示例 1:

输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
输出: [20,24]
解释:
列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
注意:

给定的列表可能包含重复元素，所以在这里升序表示 >= 。
1 <= k <= 3500
-105 <= 元素的值 <= 105
对于使用Java的用户，请注意传入类型已修改为List<List<Integer>>。重置代码模板后可以看到这项改动。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
