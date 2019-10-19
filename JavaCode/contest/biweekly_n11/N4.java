package JavaCode.contest.biweekly_n11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * author:fangjie
 * time:2019/10/19
 */
public class N4 {

    //超时
    private final static int MIN=Integer.MIN_VALUE;
    private int K;
    public int maximizeSweetness(int[] sweetness, int K) {
        System.out.println(sweetness.length);
        this.K=K;
        int[] sum=new int[sweetness.length+1];
        for (int i=0;i<sweetness.length;i++)sum[i+1]=sum[i]+sweetness[i];
        Map<Integer,Map<Integer,int[]>> dp=new HashMap<>();
        return slove(0,sweetness.length-1,sweetness,sum,K+1,dp);
    }

    private int slove(int left, int right, int[] sweetness, int[] sum, int k, Map<Integer,Map<Integer,int[]>> dp) {
        if(right-left+1<k)return MIN;
        if(k==1)return sum[right+1]-sum[left];

        dp.putIfAbsent(left,new HashMap<>());
        Map<Integer, int[]> map=dp.get(left);
        map.putIfAbsent(right,new int[K+2]);
        int[] d=map.get(right);
        if(d[k]!=0)return d[k];

        int res=0;
        for (int lk=1;lk<k;lk++)
        {
            for (int i=left+lk-1;i<right-(k-lk)+1;i++)
            {
                res=Math.max(res,Math.min(slove(left,i,sweetness,sum,lk,dp),slove(i+1,right,sweetness,sum,k-lk,dp)));
            }
        }
        return d[k]=res;
    }


}
/**
 *你有一大块巧克力，它由一些甜度不完全相同的小块组成。我们用数组 sweetness 来表示每一块的甜度。
 *
 * 你打算和你的 K 名朋友一起分享这块巧克力，所以你需要将它切割 K 次得到 K+1 块，每一块都由一些 连续 的小块组成。
 *
 * 为了表现出你的慷慨，你将会吃到 总甜度最小 的一块，并把其他几块分给你的朋友。
 *
 * 请你找出在最好的切割策略下你所能分到的巧克力的 最大总甜度 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：sweetness = [1,2,3,4,5,6,7,8,9], K = 5
 * 输出：6
 * 解释：你可以把巧克力分成 [1,2,3], [4,5], [6], [7], [8], [9]
 * 示例 2：
 *
 * 输入：sweetness = [5,6,7,8,9,1,2,3,4], K = 8
 * 输出：1
 * 解释：只有一种办法可以把巧克力分成 9 块。
 * 示例 3：
 *
 * 输入：sweetness = [1,2,2,1,2,2,1,2,2], K = 2
 * 输出：5
 * 解释：你可以把巧克力分成 [1,2,2], [1,2,2], [1,2,2]
 *
 *
 * 提示：
 *
 * 0 <= K < sweetness.length <= 10^4
 * 1 <= sweetness[i] <= 10^5
 */
