package JavaCode.random_records.N901_1000;

import java.util.*;

public class N910_smallest_range_ii {

    public int smallestRangeII(int[] A, int K) {
        if(A.length==1)return 0;
        int[][] a=new int[A.length*2][2];

        //构建新列表，保存原坐标
        int idx=0;
        for (int i=0;i<A.length;i++)
        {
            a[idx][0]=A[i]+K;
            a[idx++][1]=i;
            a[idx][0]=A[i]-K;
            a[idx++][1]=i;
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        //标记该坐标是否使用
        int[] book=new int[A.length];
        int use_cnt=0;

        //滑动窗口
        int res=Integer.MAX_VALUE;
        int left=0,right=0;
        while (right<a.length)
        {
            if(use_cnt!=A.length)
            {
                int cur = a[right][1];
                if (book[cur] == 0) {
                    use_cnt++;
                }
                book[cur]++;
                right++;
            }
            else
            {
                res=Math.min(res,a[right-1][0]-a[left][0]);
                int cur=a[left][1];
                if(--book[cur]==0)
                {
                    use_cnt--;
                }
                left++;
            }
        }
        return res;

    }
}
/**
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。
 *
 * 在此过程之后，我们得到一些数组 B。
 *
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 0
 * 输出：0
 * 解释：B = [1]
 * 示例 2：
 *
 * 输入：A = [0,10], K = 2
 * 输出：6
 * 解释：B = [2,8]
 * 示例 3：
 *
 * 输入：A = [1,3,6], K = 3
 * 输出：3
 * 解释：B = [4,6,3]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 */
