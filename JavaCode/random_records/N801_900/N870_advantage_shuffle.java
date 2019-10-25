package JavaCode.random_records.N801_900;

import java.util.*;

/**
 * author:fangjie
 * time:2019/10/25
 */
public class N870_advantage_shuffle {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int[][] b=new int[B.length][2];
        for (int i=0;i<B.length;i++)
        {
            b[i][0]=B[i];
            b[i][1]=i;
        }
        Arrays.sort(b, Comparator.comparingInt(o->o[0]));

        int[] res=new int[A.length];
        Arrays.fill(res,-1);
        LinkedList<Integer> list=new LinkedList<>();

        int idx1=0,idx2=0;
        while (idx1<A.length)
        {
            if(A[idx1]>b[idx2][0])
            {
                res[b[idx2][1]]=A[idx1];
                idx1++;
                idx2++;
            }
            else list.add(A[idx1++]);
        }

        for (int i=0;i<res.length;i++)
        {
            if(res[i]==-1)res[i]=list.poll();
        }
        return res;
    }
}
/*
给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
返回 A 的任意排列，使其相对于 B 的优势最大化。
示例 1：
输入：A = [2,7,11,15], B = [1,10,4,11]
输出：[2,11,7,15]
示例 2：
输入：A = [12,24,8,32], B = [13,25,32,11]
输出：[24,32,8,12]
提示：

1 <= A.length = B.length <= 10000
0 <= A[i] <= 10^9
0 <= B[i] <= 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/advantage-shuffle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
