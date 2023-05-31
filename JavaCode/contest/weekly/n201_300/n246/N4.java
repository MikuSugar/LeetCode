package JavaCode.contest.weekly.n201_300.n246;

import utils.Parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class N4 {
    public static void main(String[] args) {
        //[2,1,5,4,4]
        //[[1,4],[0,1],[3,4],[0,1],[1,2]]
        System.out.println(Arrays.toString(new N4().minDifference(
                Parse.toIntArr("[2,1,5,4,4]"),
                Parse.toIntTwoArr("[[1,2]]")
        )));
    }
    public int[] minDifference(int[] nums, int[][] queries) {
        List<Integer>[] lists=new List[101];
        for (int i=0;i<lists.length;i++){
            lists[i]=new ArrayList<>();
        }
        for (int i=0;i<nums.length;i++){
            lists[nums[i]].add(i);
        }
        for (List<Integer> list:lists) Collections.sort(list);

        List<Integer> t = new ArrayList<>(101);

        int[] res=new int[queries.length];
        int idx=0;
        for (int[] q:queries){
            int min=Integer.MAX_VALUE;
            t.clear();
            for (int i=0;i<=100;i++){
                if(lists[i].size()==0)continue;
                if(check(lists[i],q))t.add(i);
            }
            for (int i=1;i<t.size();i++){
                min=Math.min(min,t.get(i)-t.get(i-1));
            }
            res[idx++]=min==Integer.MAX_VALUE?-1:min;

        }
        return res;
    }

    private boolean check(List<Integer> list, int[] q) {
        int left = q[0];
        int right = q[1];
        int f=find(left,list);
        return f>=left&&f<=right;
    }

    private int find(int tar, List<Integer> list) {
        int l=0,r=list.size()-1;
        int res=-1;
        while (l<=r){
            int mid=(l+r)/2;
            if(list.get(mid)==tar)return list.get(mid);
            else if(list.get(mid)>tar){
                res=list.get(mid);
                r=mid-1;
            }
            else l=mid+1;
        }
        return res;
    }
}
/*
一个数组 a 的 差绝对值的最小值 定义为：0 <= i < j < a.length 且 a[i] != a[j] 的 |a[i] - a[j]| 的 最小值。如果 a 中所有元素都 相同 ，那么差绝对值的最小值为 -1 。

比方说，数组 [5,2,3,7,2] 差绝对值的最小值是 |2 - 3| = 1 。注意答案不为 0 ，因为 a[i] 和 a[j] 必须不相等。
给你一个整数数组 nums 和查询数组 queries ，其中 queries[i] = [li, ri] 。对于每个查询 i ，计算 子数组 nums[li...ri] 中 差绝对值的最小值 ，子数组 nums[li...ri] 包含 nums 数组（下标从 0 开始）中下标在 li 和 ri 之间的所有元素（包含 li 和 ri 在内）。

请你返回 ans 数组，其中 ans[i] 是第 i 个查询的答案。

子数组 是一个数组中连续的一段元素。

|x| 的值定义为：

如果 x >= 0 ，那么值为 x 。
如果 x < 0 ，那么值为 -x 。


示例 1：

输入：nums = [1,3,4,8], queries = [[0,1],[1,2],[2,3],[0,3]]
输出：[2,1,4,1]
解释：查询结果如下：
- queries[0] = [0,1]：子数组是 [1,3] ，差绝对值的最小值为 |1-3| = 2 。
- queries[1] = [1,2]：子数组是 [3,4] ，差绝对值的最小值为 |3-4| = 1 。
- queries[2] = [2,3]：子数组是 [4,8] ，差绝对值的最小值为 |4-8| = 4 。
- queries[3] = [0,3]：子数组是 [1,3,4,8] ，差的绝对值的最小值为 |3-4| = 1 。
示例 2：

输入：nums = [4,5,2,2,7,10], queries = [[2,3],[0,2],[0,5],[3,5]]
输出：[-1,1,1,3]
解释：查询结果如下：
- queries[0] = [2,3]：子数组是 [2,2] ，差绝对值的最小值为 -1 ，因为所有元素相等。
- queries[1] = [0,2]：子数组是 [4,5,2] ，差绝对值的最小值为 |4-5| = 1 。
- queries[2] = [0,5]：子数组是 [4,5,2,2,7,10] ，差绝对值的最小值为 |4-5| = 1 。
- queries[3] = [3,5]：子数组是 [2,7,10] ，差绝对值的最小值为 |7-10| = 3 。


提示：

2 <= nums.length <= 105
1 <= nums[i] <= 100
1 <= queries.length <= 2 * 104
0 <= li < ri < nums.length
 */
