package JavaCode.contest.n91;

public class N4 {

    public static void main(String[] args) {
        //[-28,81,-20,28,-29]
        //89
        System.out.println(new N4().shortestSubarray(new int[]{-28,91,-20,28,-29},167));
    }

    //暴力未通过，待补题
    public int shortestSubarray(int[] A, int K) {
        if(A.length==0)return -1;
        int[] sum=new int[A.length];
        sum[0]=A[0];
        for (int i=1;i<A.length;i++)
        {
            sum[i]=A[i]+sum[i-1];
        }
        int res=Integer.MAX_VALUE;
        if(sum[0]>=K)return 1;
        for (int i=1;i<A.length;i++)
        {
            if(res==Integer.MAX_VALUE)
            {
                for (int j=0;j<i;j++)
                {
                    if(sum[i]-sum[j]>=K)
                    {
                        res=Math.min(res,i-j);
                    }
                }
            }
            else
            {
                for (int j=i-1;j>=i-res;j--)
                {
                    if(sum[i]-sum[j]>=K)res=Math.min(res,i-j);
                }
            }
            if(sum[i]>=K)res=Math.min(res,i+1);
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
