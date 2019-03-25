package JavaCode.contest.n91;

import java.util.ArrayDeque;
import java.util.Deque;

public class N4 {

    public static void main(String[] args) {
        //[-28,81,-20,28,-29]
        //89
        System.out.println(new N4().shortestSubarray(new int[]{2,-1,2},3));
    }

    public int shortestSubarray(int[] A, int K) {
        int res=Integer.MAX_VALUE;
        int[] sum=new int[A.length+1];
        for (int i=0;i<A.length;i++)
        {
            sum[i+1]=sum[i]+A[i];
        }

        Deque<Integer> deque=new ArrayDeque<>();

        for (int i=0;i<sum.length;i++)
        {
            while (deque.size()>0&&sum[i]-sum[deque.getFirst()]>=K)
            {
                res=Math.min(res,i-deque.pollFirst());
            }
            while (deque.size()>0&&sum[i]<=sum[deque.getLast()])
            {
                deque.pollLast();
            }
            deque.add(i);
        }

        return res==Integer.MAX_VALUE?-1:res;
    }
}
/**
 * 862. 和至少为 K 的最短子数组  显示英文描述
 * 用户通过次数 2
 * 用户尝试次数 47
 * 通过次数 2
 * 提交次数 175
 * 题目难度 Hard
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 *
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 1
 * 输出：1
 * 示例 2：
 *
 * 输入：A = [1,2], K = 4
 * 输出：-1
 * 示例 3：
 *
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 */
