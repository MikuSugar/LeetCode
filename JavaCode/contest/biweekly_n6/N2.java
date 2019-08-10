package JavaCode.contest.biweekly_n6;

public class N2 {
    public int minSwaps(int[] data) {
        if(data==null||data.length==0)return 0;
        int[] sum=new int[data.length+1];
        for (int i=0;i<data.length;i++)
        {
            if(data[i]==1)
            {
                sum[i+1]=1+sum[i];
            }
            else sum[i+1]=sum[i];
        }
        int res=Integer.MAX_VALUE;
        int k=sum[sum.length-1];
        if(k==0)return 0;
        for (int i=k;i<sum.length;i++)
        {
            res=Math.min(k-sum[i]+sum[i-k],res);
        }
        return res;
    }
}
/**
 * 给出一个二进制数组 data，你需要通过交换位置，将数组中 任何位置 上的 1 组合到一起，并返回所有可能中所需 最少的交换次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,0,1,0,1]
 * 输出：1
 * 解释：
 * 有三种可能的方法可以把所有的 1 组合在一起：
 * [1,1,1,0,0]，交换 1 次；
 * [0,1,1,1,0]，交换 2 次；
 * [0,0,1,1,1]，交换 1 次。
 * 所以最少的交换次数为 1。
 * 示例 2：
 *
 * 输入：[0,0,0,1,0]
 * 输出：0
 * 解释：
 * 由于数组中只有一个 1，所以不需要交换。
 * 示例 3：
 *
 * 输入：[1,0,1,0,1,0,0,1,1,0,1]
 * 输出：3
 * 解释：
 * 交换 3 次，一种可行的只用 3 次交换的解决方案是 [0,0,0,0,0,1,1,1,1,1,1]。
 *
 *
 * 提示：
 *
 * 1 <= data.length <= 10^5
 * 0 <= data[i] <= 1
 */
