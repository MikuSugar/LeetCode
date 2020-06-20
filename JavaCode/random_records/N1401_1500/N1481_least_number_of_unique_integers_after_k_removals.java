package JavaCode.random_records.N1401_1500;

import java.util.*;

/**
 * @Author: fangjie
 * @Date: 2020/6/20 9:15 上午
 */
public class N1481_least_number_of_unique_integers_after_k_removals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:arr) map.put(i,map.getOrDefault(i,0)+1);
        List<Integer> list=new ArrayList<>(map.values());
        Collections.sort(list);
        int res=list.size();
        for (int i:list)
        {
            if(k>=i)res--;
            k-=i;
            if(k<=0)break;
        }
        return res;
    }
}
/*
给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。

 

示例 1：

输入：arr = [5,5,4], k = 1
输出：1
解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
示例 2：

输入：arr = [4,3,1,1,3,3,2], k = 3
输出：2
解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。
 

提示：

1 <= arr.length <= 10^5
1 <= arr[i] <= 10^9
0 <= k <= arr.length

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/least-number-of-unique-integers-after-k-removals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
