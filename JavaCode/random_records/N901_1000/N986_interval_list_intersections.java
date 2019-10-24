package JavaCode.random_records.N901_1000;

import java.util.*;

/**
 * author:fangjie
 * time:2019/10/24
 */
public class N986_interval_list_intersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res=new ArrayList<>(A.length+1);
        int idx1=0,idx2=0;
        while (idx1<A.length&&idx2<B.length)
        {
            int[] a=A[idx1];
            int[] b=B[idx2];
            if(a[1]<b[0])idx1++;
            else if(a[0]>b[1])idx2++;
            else
            {
                if(a[1]>=b[1])
                {
                    res.add(new int[]{Math.max(a[0],b[0]),b[1]});
                    idx2++;
                }
                else if(b[1]>=a[1])
                {
                    res.add(new int[]{Math.max(a[0],b[0]),a[1]});
                    idx1++;
                }
            }
        }
        int[][] ans=new int[res.size()][2];
        res.toArray(ans);
        return ans;
    }
}
/*
给定两个由一些闭区间组成的列表，每个区间列表都是成对不相交的，并且已经排序。

返回这两个区间列表的交集。

（形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。两个闭区间的交集是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）

示例：
输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
注意：输入和所需的输出都是区间对象组成的列表，而不是数组或列表。
 
提示：

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/interval-list-intersections
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
